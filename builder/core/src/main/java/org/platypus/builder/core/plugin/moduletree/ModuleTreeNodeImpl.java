package org.platypus.builder.core.plugin.moduletree;


import org.platypus.api.module.ModuleInfo;
import org.platypus.api.module.PlatypusCompleteModuleInfo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModuleTreeNodeImpl implements ModuleTreeNode{

    private final PlatypusCompleteModuleInfo current;
    private Set<ModuleTreeNodeImpl> parent = new HashSet<>();
    private Set<ModuleTreeNodeImpl> children = new HashSet<>();

    public ModuleTreeNodeImpl(PlatypusCompleteModuleInfo moduleInfo) {
        this.current = moduleInfo;
    }


    void addParent(ModuleTreeNodeImpl parent){
        if (parent == null) return;
        parent.addChilden(this);
        this.parent.add(parent);
    }

    void addChilden(ModuleTreeNodeImpl children){
        this.children.add(children);
    }

    @Override
    public PlatypusCompleteModuleInfo info() {
        return current;
    }


    @Override
    public Set<ModuleTreeNode> getChildren() {
        return new HashSet<>(children);
    }

    @Override
    public Set<ModuleTreeNode> getParent() {
        return new HashSet<>(parent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleTreeNodeImpl that = (ModuleTreeNodeImpl) o;

        return current != null ? current.getName().equals(that.current.getName()) : that.current.getName() == null;
    }

    @Override
    public int hashCode() {
        return current != null ? current.getName().hashCode() : 0;
    }
}
