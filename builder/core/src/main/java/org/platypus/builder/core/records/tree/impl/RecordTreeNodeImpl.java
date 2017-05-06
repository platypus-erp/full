package org.platypus.builder.core.records.tree.impl;

import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.RecordOfModuleInfo;
import org.platypus.builder.core.model.tree.ModelTreeNode;
import org.platypus.builder.core.model.tree.internal.ModelTreeNodeImpl;
import org.platypus.builder.core.records.tree.RecordTreeNode;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class RecordTreeNodeImpl implements RecordTreeNode{

    private final MetaInfoRecord info;
    private String moduleName;
    private Set<RecordTreeNode> children;
    private Set<RecordTreeNode> parents;

    public RecordTreeNodeImpl(MetaInfoRecord info) {
        this.info = info;
    }

    @Override
    public String getName() {
        return info.getClassName();
    }

    @Override
    public MetaInfoRecord getInfo() {
        return info;
    }

    @Override
    public Set<RecordTreeNode> getChildren() {
        return children;
    }

    @Override
    public Set<RecordTreeNode> getParent() {
        return parents;
    }

    void addParent(RecordTreeNodeImpl parent){
        if (parent == null) return;
        parent.addChilden(this);
        this.parents.add(parent);
    }

    void addChilden(RecordTreeNodeImpl children){
        this.children.add(children);
    }
}
