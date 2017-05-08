package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;
import org.platypus.api.QueryPath;
import org.platypus.api.Record;
import org.platypus.api.fields.LongField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class RecordImpl<R extends Record, RI extends R> extends AbstractFieldImpl<RI> implements GenericField<RI>, Record{

    public RecordImpl(String name, Supplier<QueryPath> getPath, Supplier<RI> getter, Consumer<RI> setter, Supplier<RI> defaultValue) {
        super(name,getPath, getter, setter, defaultValue);
    }

    protected RecordImpl(String name, Supplier<RI> defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public LongField id() {
        return getOrDefault().id();
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
