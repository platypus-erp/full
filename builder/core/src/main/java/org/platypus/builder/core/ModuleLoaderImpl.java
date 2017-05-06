package org.platypus.builder.core;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.records.quick.AstRecordRegistry;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class ModuleLoaderImpl implements ModuleLoader{

//    private PlatypusCompleteModuleInfo currentModule;
//    private ModuleTree moduleTree;
//    private ModuleTreeModel treeModel;
//    private ModelsMerged modelsMerged;
//    private RecordRegistry recordRegistry;

    public ModuleLoaderImpl(String currentModuleName){
//        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);
//        PlatypusCompleteModuleInfo currentModule = null;
//        Set<PlatypusCompleteModuleInfo> depends = new HashSet<>();
//        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos) {
//            if (currentModuleName.equals(m.techincalName())) {
//                System.out.println("current module is : " + currentModuleName);
//                currentModule = m;
//            } else {
//                depends.add(m);
//            }
//        }
//        if (currentModule == null) {
//            throw new IllegalArgumentException("Module[" + currentModuleName + "] not found");
//        }
//        execute(currentModule, depends);
    }

    public void execute(PlatypusCompleteModuleInfo currentModule, Set<PlatypusCompleteModuleInfo> depends){
//        this.currentModule = currentModule;
//        currentModule.getModel().values().forEach(m -> System.out.println(m.mtoField()));
//        ModuleTreeBuilder moduleTreePlugin = new ModuleTreeBuilder();
//        depends.forEach(moduleTreePlugin::addModule);
//        moduleTree = moduleTreePlugin.build();
//
//        FieldTreeBuilder modelTreePlugin = new FieldTreeBuilder();
//        depends.forEach(m -> modelTreePlugin.addModel(m.techincalName(), m));
//        treeModel = modelTreePlugin.build(moduleTree);
//
//        modelsMerged = new ModelMergerBuilder(treeModel).build();
//
//        recordRegistry = new RecordRegistry();
//        depends.forEach(m -> recordRegistry.addModule(m.techincalName(), m));
//        currentModule.getModel().forEach((k, v) ->
//                recordRegistry.addCurrentModuleModel(
//                        modelsMerged.getModel(k),
//                        v.getClassName()
//                )
//        );
    }



    @Override
    public PlatypusCompleteModuleInfo getCurrentModule() {
        return null;
    }

    @Override
    public ModuleTree getModuleTree() {
        return null;
    }

    @Override
    public ModelTree getModelTree() {
        return null;
    }

    @Override
    public ModelsMerged getModelsMerged() {
        return null;
    }

    @Override
    public AstRecordRegistry getRecordRegistry() {
        return null;
    }
}
