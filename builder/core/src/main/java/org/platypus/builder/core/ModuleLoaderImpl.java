package org.platypus.builder.core;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.merger.ModelMergerPlugin;
import org.platypus.builder.core.model.tree.ModelTreePlugin;
import org.platypus.builder.core.model.tree.ModuleTreeModel;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.moduletree.ModuleTreePlugin;
import org.platypus.builder.core.records.complete.RecordRegistry;

import java.util.ServiceLoader;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class ModuleLoaderImpl implements ModuleLoader{

    private PlatypusCompleteModuleInfo currentModule;
    private final ModuleTree moduleTree;
    private final ModuleTreeModel treeModel;
    private final ModelsMerged modelsMerged;
    private final RecordRegistry recordRegistry;

    public ModuleLoaderImpl(String currentModuleName){
        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);

        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos) {
            if (currentModuleName.equals(m.techincalName())) {
                System.out.println("current module is : " + currentModuleName);
                currentModule = m;
            }
        }
        if (currentModule == null) {
            throw new IllegalArgumentException("Module[" + currentModuleName + "] not found");
        }
        currentModule.getModel().values().forEach(m -> System.out.println(m.mtoField()));
        ModuleTreePlugin moduleTreePlugin = new ModuleTreePlugin();
        platypusCompleteModuleInfos.forEach(moduleTreePlugin::addModule);
        moduleTree = moduleTreePlugin.build();

        ModelTreePlugin modelTreePlugin = new ModelTreePlugin();
        platypusCompleteModuleInfos.forEach(m -> modelTreePlugin.addModel(m.techincalName(), m));
        treeModel = modelTreePlugin.build(moduleTree);

        modelsMerged = new ModelMergerPlugin(treeModel).build();


        recordRegistry = new RecordRegistry();
        platypusCompleteModuleInfos.forEach(m -> recordRegistry.addModule(m.techincalName(), m));
        currentModule.getModel().forEach((k, v) ->
                recordRegistry.addCurrentModuleModel(
                        modelsMerged.getModel(k),
                        v.getClassName()
                )
        );
    }

    @Override
    public PlatypusCompleteModuleInfo getCurrentModule() {
        return currentModule;
    }

    @Override
    public ModuleTree getModuleTree() {
        return moduleTree;
    }

    @Override
    public ModuleTreeModel getModelTree() {
        return treeModel;
    }

    @Override
    public ModelsMerged getModelsMerged() {
        return modelsMerged;
    }

    @Override
    public RecordRegistry getRecordRegistry() {
        return recordRegistry;
    }
}
