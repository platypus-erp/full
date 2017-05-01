package org.platypus.builder.core.model.tree;


import org.platypus.api.module.ModelOfModuleInfo;
import org.platypus.builder.core.model.tree.internal.ModuleTreeModelImpl;
import org.platypus.builder.core.moduletree.ModuleTree;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelTreePlugin implements ModuleTreeModel{

    private ModuleTreeModelImpl treeModel = new ModuleTreeModelImpl();

    public String name() {
        return "model-tree";
    }

    public void addModel(String moduleName, ModelOfModuleInfo moduleInfo) {
        System.out.println("addModels of " + moduleName);
        treeModel.addModule(moduleName, moduleInfo);
    }

    public ModuleTreeModel build(ModuleTree moduleTree) {
        treeModel.calculateTreeModel(moduleTree);
        return this;
    }

    @Override
    public ModelTree getBase() {
        return treeModel.getBase();
    }

    @Override
    public ModelTree getModel(String modelName) {
        return treeModel.getModel(modelName);
    }

    @Override
    public Set<String> getAllModelName() {
        return treeModel.getAllModelName();
    }

    @Override
    public Set<ModelTree> getAllModel() {
        return treeModel.getAllModel();
    }
}
