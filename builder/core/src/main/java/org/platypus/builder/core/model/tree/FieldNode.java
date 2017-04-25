package org.platypus.builder.core.model.tree;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface FieldNode<T> {

    Set<FieldNode<T>> getParents();

    T getCurrent();

    Set<FieldNode<T>> getChilds();
}