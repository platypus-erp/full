package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
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
    private final LinkedList<String> path;

    public AbstractFieldImpl(String name, Supplier<T> getter, Consumer<T> setter) {
        this.getter = getter;
        this.setter = setter;
        this.name = name;
        path = new LinkedList<>();
        path.add(name);
        path.addFirst(name);
    }

    @Override
    public T get() {
        return getter.get();
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
    public String getPath() {
        return path.stream().collect(Collectors.joining("."));
    }

    @Override
    public String[] getPathSplited() {
        return path.toArray(new String[path.size()]);
    }
}
