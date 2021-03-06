package org.platypus.builder;


import com.squareup.javapoet.JavaFile;
import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.ModuleLoader;
import org.platypus.builder.core.ModuleLoaderImpl;
import org.platypus.builder.core.api.ModelProcessor;
import org.platypus.builder.core.api.PlatypusPlugin;
import org.platypus.builder.core.api.ProcessState;
import org.platypus.builder.core.api.impl.Config;
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.core.service.manager.ServiceGenerator;

import java.io.IOException;
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

    private final ModuleLoader moduleLoader;
    private final Map<String, PlatypusPlugin> pluginsDiscovered = new HashMap<>();
    private final Config config;
    private final List<ModelProcessor> modelProcessors = new ArrayList<>();
    private final MainArgs mainArgs;

    public static void main(String... args) {
        new PlatypusBuilder(new MainArgs(args)).run();
    }

    public static PlatypusBuilder of(MainArgs mainArgs) {
        return new PlatypusBuilder(mainArgs);
    }

    private PlatypusBuilder(MainArgs mainArgs) {
        this.mainArgs = mainArgs;

        moduleLoader = new ModuleLoaderImpl(mainArgs);

        System.out.println("Load of platypus model processor");
        ServiceLoader<ModelProcessor> modelProcessorsService = ServiceLoader.load(ModelProcessor.class);
        modelProcessorsService.forEach(modelProcessors::add);
        System.out.println(modelProcessors.size()+" Model Processor loaded");

        config = new Config(moduleLoader, mainArgs.conf, mainArgs.defaultPkg);



        System.out.println("Load of platypus plugins");
        ServiceLoader<PlatypusPlugin> plugins = ServiceLoader.load(PlatypusPlugin.class);
        plugins.forEach(p -> p.applyConf(mainArgs.conf.getOrDefault(p.getName(), p.getDefaultConf())));
        plugins.forEach(p -> pluginsDiscovered.put(p.getName(), p));
    }

    public void run() {
        System.out.println();
        runDefaultGenerator();
        runModelProcessor();
        runPlugins(pluginsDiscovered.keySet().toArray(new String[0]));
    }

    private void runDefaultGenerator(){
        ServiceGenerator.generateRecord(mainArgs, moduleLoader.getServiceRegistry().getServices());
    }

    public void runModelProcessor() {
        modelProcessors.sort(Comparator.comparingInt(ModelProcessor::priority));
        modelProcessors.forEach(m -> m.init(config));

        for (ModelMerged model : moduleLoader.getModelsMerged().getModels()
                .collect(Collectors.toSet())) {
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
                    files.build().writeTo(mainArgs.projectDirGenerated.toFile());
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
