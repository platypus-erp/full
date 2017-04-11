package org.platypus.builder.core;


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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public final class Platypus {

    private final Map<String, ModelMerged> modelMerged;
    private final Config config;
    List<ModelProcessor> modelProcessors = new ArrayList<>();
    public Platypus() {
        String currentModuleName = "sample_depends";
        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);

        PlatypusCompleteModuleInfo currentModule = null;
        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos){
            if (currentModuleName.equals(m.techincalName())){
                System.out.println("current module is : "+ currentModuleName);
                currentModule = m;
            }
        }
        if (currentModule == null){
            throw new IllegalArgumentException("Module["+currentModuleName+"] not found");
        }

        ModuleTreePlugin moduleTreePlugin = new ModuleTreePlugin();
        platypusCompleteModuleInfos.forEach(moduleTreePlugin::addModule);
        ModuleTreeImpl moduleTree = moduleTreePlugin.build();

        ModelTreePlugin modelTreePlugin = new ModelTreePlugin();
        platypusCompleteModuleInfos.forEach(m -> modelTreePlugin.addModel(m.techincalName(), m));
        ModuleTreeModel treeModel = modelTreePlugin.build(moduleTree);

        ModelMergerPlugin modelMergerPlugin = new ModelMergerPlugin(treeModel);
        modelMerged = modelMergerPlugin.build();

        config = new Config(currentModule, moduleTree,treeModel, modelMerged);

        ServiceLoader<ModelProcessor> modelProcessorsService = ServiceLoader.load(ModelProcessor.class);
        modelProcessorsService.forEach(modelProcessors::add);

        System.out.println("Load of platypus plugins");
        ServiceLoader<PlatypusPlugin> plugins = ServiceLoader.load(PlatypusPlugin.class);
        plugins.forEach(config::addPlugin);


    }

    public void run(String... args){
        System.out.println(Arrays.toString(args));
        runModelProcessor(args);
        runPlugins(args);
    }

    public void runModelProcessor(String... args){
        modelProcessors.sort(Comparator.comparingInt(ModelProcessor::priority));
        modelProcessors.forEach(m -> m.init(config));

        for (ModelMerged model : modelMerged.values()){
            for (ModelProcessor processor:modelProcessors){
                if (processor.process(model)){
                    continue;
                }
            }

        }
    }

    public void runPlugins(String ... pluginsToRun){
        Arrays.sort(pluginsToRun);
        config.initPlugins(pluginsToRun);
        config.runPlugins(pluginsToRun);
        config.destroyPlugins(pluginsToRun);
    }


}
