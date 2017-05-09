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

    protected final Supplier<T> getter;
    protected final Consumer<T> setter;
    protected final String name;
    protected Supplier<QueryPath> path;

    public AbstractFieldImpl(String name,
                             Supplier<QueryPath> getPath,
                             Supplier<T> getter,
                             Consumer<T> setter) {
        this.getter = getter;
        this.setter = setter;
        this.name = name;
        path = () -> getPath.get().resolve(name);
    }

    public AbstractFieldImpl(String name) {
        this(name, QueryPath::new);
    }
    public AbstractFieldImpl(String name, Supplier<QueryPath> getPath) {
        this.getter = () -> {
            throw new UnsupportedOperationException("can't be called");
        };
        this.setter = m -> {
            throw new UnsupportedOperationException("can't be called");
        };
        this.name = name;
        path = () -> getPath.get().resolve(name);
    }

    @Override
    public T get() {
        return getter.get();
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
        return new QueryPath(path.get());
    }
}
