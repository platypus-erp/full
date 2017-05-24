package org.platypus.api;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface UnmutableGenericField<T> extends PlatypusField<T>, Booleanable, EmptyCheckable{

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
