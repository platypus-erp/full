package org.platypus.builder.core.model.tree.internal;


import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.builder.core.model.tree.ModelTreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelTreeNodeImpl implements ModelTreeNode {

    private final MetaInfoModel info;
    private String moduleName;
    private Set<ModelTreeNode> children= new HashSet<>();
    private Set<ModelTreeNode> parents= new HashSet<>();

    public ModelTreeNodeImpl(MetaInfoModel info) {
        this.info = info;
    }

    @Override
    public MetaInfoModel getInfo() {
        return info;
    }

    @Override
    public Set<ModelTreeNode> getChildren() {
        return children;
    }

    @Override
    public Set<ModelTreeNode> getParent() {
        return parents;
    }

    void addParent(ModelTreeNodeImpl parent){
        if (parent == null) return;
        parent.addChilden(this);
        this.parents.add(parent);
    }

    void addChilden(ModelTreeNodeImpl children){
        this.children.add(children);
    }
}
