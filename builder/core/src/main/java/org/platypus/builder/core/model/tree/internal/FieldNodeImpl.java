package org.platypus.builder.core.model.tree.internal;


import org.platypus.builder.core.model.tree.FieldNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FieldNodeImpl<T> implements FieldNode<T> {

    private final Set<FieldNodeImpl<T>> parents = new HashSet<>();
    private final T current;
    private final Set<FieldNodeImpl<T>> childs= new HashSet<>();


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
