package org.platypus.builder.core.service.tree.impl;

import org.platypus.builder.core.service.tree.BusinessTree;
import org.platypus.builder.core.service.tree.BusinessTreeNode;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.model.tree.ModelTreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/05/17.
 */
public class BusinessTreeImpl implements BusinessTree {

    private final Map<String, BusinessTreeNodeImpl> modulesNodeByName;
    private Set<BusinessTreeNode> allModelTree;
    private final Map<String, BusinessTreeNodeImpl> modelsTreeLast;

    public BusinessTreeImpl() {
        modulesNodeByName = new HashMap<>();
        modelsTreeLast = new HashMap<>();
    }

    public BusinessTreeNode getRecord(String modelName) {
        return modulesNodeByName.get(modelName);
    }

    @Override
    public BusinessTreeNode getMethod(String methodName) {
        return null;
    }

    @Override
    public Set<String> getAllRecordName() {
        return modulesNodeByName.keySet();
    }

    @Override
    public Set<BusinessTreeNode> getRecordModel() {
        return allModelTree;
    }

    public void calculateTreeModel(ModelTree modelTree) {
        Map<String, BusinessTreeNodeImpl> recordTree = new HashMap<>();
        for (ModelTreeNode modelTreeNode : modelTree.getAllModel()) {
            recursiveCalculateTree(modelTreeNode, recordTree);
        }
        allModelTree = Collections.unmodifiableSet(new HashSet<>(recordTree.values()));
    }

    private void recursiveCalculateTree(ModelTreeNode modelTreeNode, Map<String, BusinessTreeNodeImpl> modelsTree) {
//        MetaInfoModel infoModel = modelTreeNode.getInfo();
//        String recordClassName = StringUtils.capitalize(infoModel.getModuleName())
//                + StringUtils.capitalize(infoModel.getClassName())
//                + "Record";
//        MetaInfoRecordImpl i = new MetaInfoRecordImpl(
//                infoModel.getPkg() + ".generated.records",
//                recordClassName,
//                infoModel.getName(),
//                infoModel.getClassName(),
//                infoModel.getPkg()
//        );
//        BusinessTreeNodeImpl rtni = new BusinessTreeNodeImpl(i);
//        if (modelsTree.putIfAbsent(infoModel.getName(), rtni) != null) {
//            modelsTreeLast.get(infoModel.getName()).addParent(rtni);
//        }
//        modelsTreeLast.put(infoModel.getName(), rtni);
//        for (ModelTreeNode parent : modelTreeNode.getParent()) {
//            recursiveCalculateTree(parent, modelsTree);
//        }
    }
}
