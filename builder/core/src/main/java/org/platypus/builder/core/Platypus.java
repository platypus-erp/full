package org.platypus.builder.core;


import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.plugin.Config;
import org.platypus.builder.core.plugin.PlatypusPlugin;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.core.plugin.model.merger.ModelMergerPlugin;
import org.platypus.builder.core.plugin.model.tree.ModelTreePlugin;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;
import org.platypus.builder.core.plugin.moduletree.ModuleTreeImpl;
import org.platypus.builder.core.plugin.moduletree.ModuleTreePlugin;

import java.util.Map;
import java.util.ServiceLoader;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class Platypus {


    public Platypus() {
        String currentModuleName = "sample_erp";
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
        Map<String, ModelMerged> modelMerged = modelMergerPlugin.build();

        Config config = new Config(currentModule, moduleTree,treeModel, modelMerged);

        ServiceLoader<PlatypusPlugin> plugins = ServiceLoader.load(PlatypusPlugin.class);
        plugins.forEach(config::addPlugin);

        config.initPlugins();

        System.out.println("Load of platypus plugins");
    }


}
