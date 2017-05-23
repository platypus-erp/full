package org.platypus.builder.core.model.merger.internal.field;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface FieldMerger<T> {
    FieldMerger<T> merge(T def);

    T toValue();
}
