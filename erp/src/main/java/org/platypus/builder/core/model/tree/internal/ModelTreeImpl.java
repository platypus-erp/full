package org.platypus.builder.core.model.tree.internal;


import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.ModelOfModuleInfo;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.model.tree.ModelTreeNode;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.moduletree.ModuleTreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelTreeImpl implements ModelTree{

    private final Map<String, ModelOfModuleInfo> modulesNodeByName;
    private Set<ModelTreeNode> allModelTree;
    private final Map<String, ModelTreeNodeImpl> modelsTreeLast;

    public ModelTreeImpl() {
        modulesNodeByName = new HashMap<>();
        modelsTreeLast = new HashMap<>();
    }

    @Override
    public ModelTreeNode getModel(String modelName) {
        return modelsTreeLast.get(modelName);
    }

    @Override
    public Set<String> getAllModelName() {
        return modelsTreeLast.keySet();
    }

    @Override
    public Set<ModelTreeNode> getAllModel() {
        return allModelTree;
    }

    public void addModule(String moduleName, ModelOfModuleInfo moduleInfo) {
        modulesNodeByName.put(moduleName, moduleInfo);
    }

    public void calculateTreeModel(ModuleTree moduleTree) {
        ModuleTreeNode base = moduleTree.getBase();
        Map<String, ModelTreeNodeImpl> modelsTree = new HashMap<>();
        recursiveCalculateTree(base, modelsTree);
        allModelTree = Collections.unmodifiableSet(new HashSet<>(modelsTree.values()));
    }

    private void recursiveCalculateTree(ModuleTreeNode node, Map<String, ModelTreeNodeImpl> modelsTree) {
        if (node == null){
            return;
        }
        for (MetaInfoModel model : modulesNodeByName.get(node.info().techincalName()).getModel().values()) {
            ModelTreeNodeImpl modelTree = new ModelTreeNodeImpl(model);
            if (modelsTree.putIfAbsent(model.getName(), modelTree) != null) {
                modelsTreeLast.get(model.getName()).addParent(modelTree);
            }
            modelsTreeLast.put(model.getName(), modelTree);
        }
        for (ModuleTreeNode parent : node.getParent()) {
            recursiveCalculateTree(parent, modelsTree);
        }


    }
}
