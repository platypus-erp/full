package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;
import org.platypus.api.SetPathable;
import org.platypus.api.query.QueryPath;
import org.platypus.api.Record;
import org.platypus.api.fields.LongField;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public abstract class RecordImpl<R extends Record, RI extends R> implements GenericField<RI>, Record {
    protected Supplier<RI> defaultValue;
    protected final Supplier<RI> getter;
    protected final Consumer<RI> setter;
    protected final String name;
    protected Supplier<QueryPath> path;

    protected RecordImpl(String tableName,
                         String name,
                         Supplier<QueryPath> getPath,
                         Supplier<RI> getter,
                         Consumer<RI> setter,
                         Supplier<RI> defaultValue) {
        this.getter = getter;
        this.setter = setter;
        this.name = name;
        path = () -> getPath.get().resolve(QueryPath.relation(tableName, name));
        this.defaultValue = defaultValue;
    }



    @Override
    public RI get() {
        return getter.get();
    }

    @Override
    public RI getOrDefault(RI defaultValue) {
        RI result = getter.get();
        return result != null ? result : defaultValue;
    }

    @Override
    public void set(RI value) {
        setter.accept(value);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public QueryPath getPath() {
        return path.get();
    }

    @Override
    public QueryPath resolve(QueryPath queryPath) {
        return getPath().resolve(queryPath);
    }

    @Override
    public RI getDefaultValue() {
        RI def = defaultValue.get();
        def.setPath(getPath().resolve(def.getPath()));
        return def;
    }

    @Override
    public void setPath(QueryPath queryPath) {
        get().setPath(queryPath);
    }

    @Override
    public LongField id() {
        return getDefaultValue().id();
    }
}
