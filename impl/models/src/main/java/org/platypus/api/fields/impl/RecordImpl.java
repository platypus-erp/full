package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;
import org.platypus.api.QueryPath;
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
public class RecordImpl<R extends Record, RI extends R> extends AbstractFieldImpl<RI> implements GenericField<RI>, Record{
    protected Function<Supplier<QueryPath>, Supplier<RI>> defaultValue;

    protected RecordImpl(String name, Supplier<QueryPath> getPath, Supplier<RI> getter, Consumer<RI> setter,
                         Function<Supplier<QueryPath>, Supplier<RI>> defaultValue) {
        super(name,getPath, getter, setter);
        this.defaultValue = defaultValue;
    }

    protected RecordImpl(String name, Function<Supplier<QueryPath>, Supplier<RI>> defaultValue) {
        super(name);
        this.defaultValue = defaultValue;
    }

    protected RecordImpl(String name, Supplier<QueryPath> getPath, Function<Supplier<QueryPath>, Supplier<RI>> defaultValue) {
        super(name, getPath);
        this.defaultValue = defaultValue;
    }

    @Override
    public RI getDefaultValue() {
        return defaultValue.apply(path).get();
    }

    @Override
    public LongField id() {
        return getDefaultValue().id();
    }


    //
//    @Override
//    public void id(long id) {
//        get().id(id);
//    }
//
//    @Override
//    public void id(LongField id) {
//        get().id(id);
//    }
//
//    @Override
//    public UnmutableDateTimeField createDate() {
//        return get().createDate();
//    }
//
//    @Override
//    public UnmutableDateTimeField writeDate() {
//        return get().writeDate();
//    }
//
//    @Override
//    public UnmutableStringField displayName() {
//        return get().displayName();
//    }
//    @Override
//    public <T extends Record> T unWrap(Class<T> type) {
//        return type.cast(instance);
//    }
}
