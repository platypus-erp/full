package org.platypus.builder.core.service.tree.impl;

import org.platypus.builder.core.service.MetaInfoBusinessMethod;
import org.platypus.builder.core.service.tree.BusinessTreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class BusinessTreeNodeImpl implements BusinessTreeNode {

    private final MetaInfoBusinessMethod info;
    private String moduleName;
    private Set<BusinessTreeNode> children= new HashSet<>();
    private Set<BusinessTreeNode> parents= new HashSet<>();

    public BusinessTreeNodeImpl(MetaInfoBusinessMethod info) {
        this.info = info;
    }

    @Override
    public String getName() {
        return info.toString();
    }

    @Override
    public MetaInfoBusinessMethod getInfo() {
        return info;
    }

    @Override
    public Set<BusinessTreeNode> getChildren() {
        return children;
    }

    @Override
    public Set<BusinessTreeNode> getParent() {
        return parents;
    }

    void addParent(BusinessTreeNodeImpl parent){
        if (parent == null) return;
        parent.addChilden(this);
        this.parents.add(parent);
    }

    void addChilden(BusinessTreeNodeImpl children){
        this.children.add(children);
    }
}
