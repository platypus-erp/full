package org.platypus.builder.core;


import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.plugin.Config;
import org.platypus.builder.core.plugin.ModelProcessor;
import org.platypus.builder.core.plugin.PlatypusPlugin;
import org.platypus.builder.core.plugin.ProcessState;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.core.plugin.model.merger.ModelMergerPlugin;
import org.platypus.builder.core.plugin.model.tree.ModelTreePlugin;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;
import org.platypus.builder.core.plugin.moduletree.ModuleTreeImpl;
import org.platypus.builder.core.plugin.moduletree.ModuleTreePlugin;
import org.platypus.builder.core.plugin.record.RecordRegistry;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

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
    private final MainArgs mainArgs;

    public static void main(String... args) {
        System.out.println(Arrays.toString(args));
        new PlatypusBuilder(new MainArgs(args)).run();
    }

    public static PlatypusBuilder of(MainArgs mainArgs) {
        return new PlatypusBuilder(mainArgs);
    }

    private PlatypusBuilder(MainArgs mainArgs) {
        this.mainArgs = mainArgs;


        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);

        PlatypusCompleteModuleInfo currentModule = null;
        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos) {
            if (mainArgs.getModulename().equals(m.techincalName())) {
                System.out.println("current module is : " + mainArgs.getModulename());
                currentModule = m;
            }
        }
        if (currentModule == null) {
            throw new IllegalArgumentException("Module[" + mainArgs.getModulename() + "] not found");
        }

        ModuleTreePlugin moduleTreePlugin = new ModuleTreePlugin();
        platypusCompleteModuleInfos.forEach(moduleTreePlugin::addModule);
        ModuleTreeImpl moduleTree = moduleTreePlugin.build();

        ModelTreePlugin modelTreePlugin = new ModelTreePlugin();
        platypusCompleteModuleInfos.forEach(m -> modelTreePlugin.addModel(m.techincalName(), m));
        ModuleTreeModel treeModel = modelTreePlugin.build(moduleTree);

        ModelMergerPlugin modelMergerPlugin = new ModelMergerPlugin(treeModel);
        modelMerged = modelMergerPlugin.build();


        RecordRegistry recordRegistry = new RecordRegistry();
        platypusCompleteModuleInfos.forEach(m -> recordRegistry.addModule(m.techincalName(), m));
        currentModule.getModel().forEach((k, v) ->
                recordRegistry.addCurrentModuleModel(
                        modelMergerPlugin.getModel().get(k),
                        v.getClassName()
                )
        );
        Set<JavaFile.Builder> recordToCreate = recordRegistry.generateCurrentModuleRecord(mainArgs.getDefaultPkg());
        for (JavaFile.Builder files : recordToCreate) {
            System.out.println(files.build().packageName);
            try {
                files.build().writeTo(mainArgs.getProjectDirGenerated().resolve("records").toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = new Config(
                currentModule,
                moduleTree,
                treeModel,
                modelMerged,
                mainArgs.getConf(),
                mainArgs.getDefaultPkg()
        );

        System.out.println("Load of platypus model processor");
        ServiceLoader<ModelProcessor> modelProcessorsService = ServiceLoader.load(ModelProcessor.class);
        modelProcessorsService.forEach(modelProcessors::add);

        System.out.println("Load of platypus plugins");
        ServiceLoader<PlatypusPlugin> plugins = ServiceLoader.load(PlatypusPlugin.class);
        plugins.forEach(p -> p.applyConf(mainArgs.getConf().getOrDefault(p.getName(), p.getDefaultConf())));
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
                if (processor.process(model, config, ProcessState.IN_PROGRESS)) {
                    continue;
                }
            }
        }
        modelProcessors.forEach(p -> p.process(null, config, ProcessState.FINISH));

        for (ModelProcessor processor : modelProcessors) {
            for (JavaFile.Builder files : processor.getResultProcessing(config).getAllFile()) {
                System.out.println(files.build().packageName);
                try {
                    files.build().writeTo(mainArgs.getProjectDirGenerated().toFile());
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
