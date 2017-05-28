package org.platypus.api;

import org.platypus.api.fields.FieldType;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface PlatypusField<T> extends Namable, Pathable, EmptyCheckable {
    T get();
}
