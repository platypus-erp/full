package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;
import org.platypus.api.QueryPath;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
abstract class AbstractFieldImpl<T> implements GenericField<T> {

    private final Supplier<T> getter;
    private final Consumer<T> setter;
    private final String name;
    private final Supplier<T> defaultValue;
    protected final QueryPath path;

    public AbstractFieldImpl(String name,
                             Supplier<QueryPath> getPath,
                             Supplier<T> getter,
                             Consumer<T> setter,
                             Supplier<T> defaultValue) {
        this.getter = getter;
        this.setter = setter;
        this.name = name;
        this.defaultValue = defaultValue;
        path = getPath.get().resolve(name);
    }

    public AbstractFieldImpl(String name,Supplier<T> defaultValue) {
        this(name,
                QueryPath::new,
                () -> {
                    throw new UnsupportedOperationException("can't be called");
                },
                m -> {
                    throw new UnsupportedOperationException("can't be called");
                },
                defaultValue);
    }

    @Override
    public T get() {
        return getter.get();
    }

    @Override
    public T getDefaultValue() {
        return defaultValue.get();
    }

    @Override
    public T getOrDefault(T defaultValue) {
        T result = getter.get();
        return result != null ? result : defaultValue;
    }

    @Override
    public void set(T value) {
        setter.accept(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public QueryPath getPath() {
        return path;
    }
}
