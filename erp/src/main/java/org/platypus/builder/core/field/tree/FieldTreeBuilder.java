package org.platypus.builder.core.field.tree;


import org.platypus.api.module.ModelOfModuleInfo;
import org.platypus.builder.core.field.tree.internal.FieldTreeApiImpl;
import org.platypus.builder.core.moduletree.ModuleTree;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FieldTreeBuilder implements FieldTreeApi{

    private FieldTreeApiImpl treeModel = new FieldTreeApiImpl();

    public String name() {
        return "model-tree";
    }

    public static FieldTreeApiImpl emptyTree(){
        return new FieldTreeApiImpl();
    }

    public void addModel(String moduleName, ModelOfModuleInfo moduleInfo) {
        System.out.println("addModels of " + moduleName);
        treeModel.addModule(moduleName, moduleInfo);
    }

    public FieldTreeApi build(ModuleTree moduleTree) {
        treeModel.calculateTreeModel(moduleTree);
        return this;
    }

    @Override
    public FieldTree getModel(String modelName) {
        return treeModel.getModel(modelName);
    }

    @Override
    public Set<String> getAllModelName() {
        return treeModel.getAllModelName();
    }

    @Override
    public Set<FieldTree> getAllModel() {
        return treeModel.getAllModel();
    }
}
