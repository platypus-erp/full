package org.platypus.builder.core;


import com.squareup.javapoet.JavaFile;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.plugin.Config;
import org.platypus.builder.core.plugin.ModelProcessor;
import org.platypus.builder.core.plugin.PlatypusPlugin;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.core.plugin.model.merger.ModelMergerPlugin;
import org.platypus.builder.core.plugin.model.tree.ModelTreePlugin;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;
import org.platypus.builder.core.plugin.moduletree.ModuleTreeImpl;
import org.platypus.builder.core.plugin.moduletree.ModuleTreePlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public final class PlatypusBuilder {

    private final Map<String, ModelMerged> modelMerged;
    private final Map<String, PlatypusPlugin> pluginsDiscovered = new HashMap<>();
    private final Config config;
    private final List<ModelProcessor> modelProcessors = new ArrayList<>();
    private final Map<String, String> argsMap;
    private final Path projectDir;
    private final Path projectDirGenerated;

    public static void main(String... args) {
        new PlatypusBuilder(args).run();
    }

    private PlatypusBuilder(String... args) {
        System.out.println(Arrays.toString(args));
        argsMap = Arrays.stream(args)
                .map(s -> s.split("="))
                .collect(Collectors.toMap(t -> t[0], t -> t[1]));

        projectDir = Paths.get(argsMap.get("--directory"));
        projectDirGenerated = Paths.get(argsMap.get("--directory"), "src", "platypusgenerated", "java");
        String currentModuleName = argsMap.get("--modulename");
        String defaultpkg = argsMap.get("--defaultpkg");


        Map<String, PluginConf> conf = Stream.of(argsMap.getOrDefault("--plugins", ""))
                .map(s -> s.substring(1, s.length()-1))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(PluginConf::new)
                .collect(Collectors.toMap(PluginConf::getName, c -> c));

        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);

        PlatypusCompleteModuleInfo currentModule = null;
        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos) {
            if (currentModuleName.equals(m.techincalName())) {
                System.out.println("current module is : " + currentModuleName);
                currentModule = m;
            }
        }
        if (currentModule == null) {
            throw new IllegalArgumentException("Module[" + currentModuleName + "] not found");
        }

        ModuleTreePlugin moduleTreePlugin = new ModuleTreePlugin();
        platypusCompleteModuleInfos.forEach(moduleTreePlugin::addModule);
        ModuleTreeImpl moduleTree = moduleTreePlugin.build();

        ModelTreePlugin modelTreePlugin = new ModelTreePlugin();
        platypusCompleteModuleInfos.forEach(m -> modelTreePlugin.addModel(m.techincalName(), m));
        ModuleTreeModel treeModel = modelTreePlugin.build(moduleTree);

        ModelMergerPlugin modelMergerPlugin = new ModelMergerPlugin(treeModel);
        modelMerged = modelMergerPlugin.build();

        config = new Config(currentModule, moduleTree, treeModel, modelMerged, conf, defaultpkg);

        System.out.println("Load of platypus model processor");
        ServiceLoader<ModelProcessor> modelProcessorsService = ServiceLoader.load(ModelProcessor.class);
        modelProcessorsService.forEach(modelProcessors::add);

        System.out.println("Load of platypus plugins");
        ServiceLoader<PlatypusPlugin> plugins = ServiceLoader.load(PlatypusPlugin.class);
        plugins.forEach(p -> p.applyConf(conf.getOrDefault(p.getName(), p.getDefaultConf())));
        plugins.forEach(p -> pluginsDiscovered.put(p.getName(), p));
    }

    public void run() {
        System.out.println();
        runModelProcessor();
        runPlugins(pluginsDiscovered.keySet().toArray(new String[0]));
    }

    public void runModelProcessor() {
        modelProcessors.sort(Comparator.comparingInt(ModelProcessor::priority));
        modelProcessors.forEach(m -> m.init(config));

        for (ModelMerged model : modelMerged.values()) {
            for (ModelProcessor processor : modelProcessors) {
                if (processor.process(model, config)) {
                    continue;
                }
            }
        }
        for (ModelProcessor processor : modelProcessors) {
            for (JavaFile.Builder files : processor.afterProcess(config).getAllFile()) {
                System.out.println(files.build().packageName);
                try {
                    files.build().writeTo(projectDirGenerated.toFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void runPlugins(String... pluginsToRun) {
        System.out.println(Arrays.toString(pluginsToRun));

        Set<PlatypusPlugin> plugins = Arrays.stream(pluginsToRun)
                .filter(s -> config.getPluginConfig(s).isPresent())
                .filter(s -> config.getPluginConfOrThrow(s).isEnable())
                .filter(pluginsDiscovered::containsKey)
                .map(pluginsDiscovered::get)
                .collect(Collectors.toSet());


        plugins.forEach(p -> p.init(config));
        plugins.forEach(p -> p.execute(config));
        plugins.forEach(p -> p.after(config));
        plugins.forEach(p -> p.detroy(config));
    }


}
