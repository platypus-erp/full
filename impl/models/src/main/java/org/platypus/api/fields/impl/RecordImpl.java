package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;
import org.platypus.api.Record;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.UnmutableDateTimeField;
import org.platypus.api.fields.UnmutableStringField;

import java.util.function.BiConsumer;
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

    public RecordImpl(String name, Supplier<RI> getter, Consumer<RI> setter) {
        super(name, getter, setter);
    }

    @Override
    public LongField id() {
        return get().id();
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
