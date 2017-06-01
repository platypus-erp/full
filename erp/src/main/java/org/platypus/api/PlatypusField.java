package org.platypus.api;

import org.platypus.api.query.projection.PProjection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface PlatypusField<T> extends Namable, Pathable, EmptyCheckable, Booleanable {
    T get();

    PProjection getProjection();

    void set(T value);

    default T getOrDefault(T defaultValue){
        T result = get();
        return result != null ? result : defaultValue;
    }

    default T getOrDefault(){
        T result = get();
        return result != null ? result : getDefaultValue();
    }

    T getDefaultValue();

    @Override
    default boolean bool() {
        return get() != null;
    }

    @Override
    default boolean isEmpty() {
        return get() == null;
    }
}
