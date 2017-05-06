package org.platypus.builder.core.model.tree;


import org.platypus.api.module.ModelOfModuleInfo;
import org.platypus.builder.core.field.tree.internal.FieldTreeApiImpl;
import org.platypus.builder.core.model.tree.internal.ModelTreeImpl;
import org.platypus.builder.core.moduletree.ModuleTree;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelTreeBuilder implements ModelTree {

    private ModelTreeImpl treeModel = new ModelTreeImpl();

    public String name() {
        return "model-tree";
    }

    public void addModel(String moduleName, ModelOfModuleInfo moduleInfo) {
        System.out.println("addModels of " + moduleName);
        treeModel.addModule(moduleName, moduleInfo);
    }

    public static ModelTreeImpl emptyTree(){
        return new ModelTreeImpl();
    }

    public ModelTree build(ModuleTree moduleTree) {
        treeModel.calculateTreeModel(moduleTree);
        return this;
    }

    @Override
    public ModelTreeNode getModel(String modelName) {
        return treeModel.getModel(modelName);
    }

    @Override
    public Set<String> getAllModelName() {
        return treeModel.getAllModelName();
    }

    @Override
    public Set<ModelTreeNode> getAllModel() {
        return treeModel.getAllModel();
    }
}
