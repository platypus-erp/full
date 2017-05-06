package org.platypus.builder.core.records.tree.impl;

import org.apache.commons.lang3.StringUtils;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.model.tree.ModelTreeNode;
import org.platypus.builder.core.records.tree.RecordTree;
import org.platypus.builder.core.records.tree.RecordTreeNode;
import orp.platypus.impl.module.MetaInfoRecordImpl;

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
public class RecordTreeImpl implements RecordTree{

    private final Map<String, RecordTreeNodeImpl> modulesNodeByName;
    private Set<RecordTreeNode> allModelTree;
    private final Map<String, RecordTreeNodeImpl> modelsTreeLast;

    public RecordTreeImpl() {
        modulesNodeByName = new HashMap<>();
        modelsTreeLast = new HashMap<>();
    }

    @Override
    public RecordTreeNode getRecord(String modelName) {
        return modulesNodeByName.get(modelName);
    }

    @Override
    public Set<String> getAllRecordName() {
        return modulesNodeByName.keySet();
    }

    @Override
    public Set<RecordTreeNode> getRecordModel() {
        return allModelTree;
    }

    public void calculateTreeModel(ModelTree modelTree) {
        Map<String, RecordTreeNodeImpl> recordTree = new HashMap<>();
        for (ModelTreeNode modelTreeNode : modelTree.getAllModel()) {
            recursiveCalculateTree(modelTreeNode, recordTree);
        }
        allModelTree = Collections.unmodifiableSet(new HashSet<>(recordTree.values()));
    }

    private void recursiveCalculateTree(ModelTreeNode modelTreeNode, Map<String, RecordTreeNodeImpl> modelsTree) {
        MetaInfoModel infoModel = modelTreeNode.getInfo();
        String recordClassName = StringUtils.capitalize(infoModel.getModuleName())
                + StringUtils.capitalize(infoModel.getClassName())
                + "Record";
        MetaInfoRecordImpl i = new MetaInfoRecordImpl(
                infoModel.getPkg() + ".generated.records",
                recordClassName,
                infoModel.getName(),
                infoModel.getClassName(),
                infoModel.getPkg()
        );
        RecordTreeNodeImpl rtni = new RecordTreeNodeImpl(i);
        if (modelsTree.putIfAbsent(infoModel.getName(), rtni) != null) {
            modelsTreeLast.get(infoModel.getName()).addParent(rtni);
        }
        modelsTreeLast.put(infoModel.getName(), rtni);
        for (ModelTreeNode parent : modelTreeNode.getParent()) {
            recursiveCalculateTree(parent, modelsTree);
        }
    }
}
