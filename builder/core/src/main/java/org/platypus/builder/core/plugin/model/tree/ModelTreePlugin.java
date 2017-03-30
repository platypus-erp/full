package org.platypus.builder.core.plugin.model.tree;


import org.platypus.api.module.ModelOfModuleInfo;
import org.platypus.builder.core.plugin.model.tree.internal.ModuleTreeModelImpl;
import org.platypus.builder.core.plugin.moduletree.ModuleTreeImpl;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelTreePlugin {

    private ModuleTreeModelImpl treeModel = new ModuleTreeModelImpl();

    public String name() {
        return "model-tree";
    }

    public void addModel(String moduleName, ModelOfModuleInfo moduleInfo) {
        System.out.println("execute" + moduleName);
        treeModel.addModule(moduleName, moduleInfo);
    }

    public ModuleTreeModel build(ModuleTreeImpl moduleTree) {
        treeModel.calculateTreeModel(moduleTree);
        return treeModel;
    }

    public ModuleTreeModel getTree(){
        return treeModel;
    }

}
