package org.platypus.builder.core.plugin.model.tree.internal;


import org.platypus.builder.core.plugin.model.tree.FieldNode;

import java.util.Collections;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FieldNodeImpl<T> implements FieldNode<T> {

    private Set<FieldNodeImpl<T>> parents;
    private final T current;
    private Set<FieldNodeImpl<T>> childs;


    public FieldNodeImpl(T f) {
        this.current = f;
    }

    public void addChild(FieldNodeImpl<T> child){
        child.parents.add(this);
        childs.add(child);
    }

    @Override
    public Set<FieldNode<T>> getParents() {
        return Collections.unmodifiableSet(parents);
    }

    @Override
    public T getCurrent() {
        return current;
    }

    @Override
    public Set<FieldNode<T>> getChilds() {
        return Collections.unmodifiableSet(childs);
    }
}
