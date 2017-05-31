package org.platypus.api.fields.impl;

import org.platypus.api.fields.TimeField;
import org.platypus.api.query.QueryPath;

import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class TimeFieldImpl extends AbstractFieldImpl<LocalTime> implements TimeField {


    public TimeFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<LocalTime> getter, Consumer<LocalTime> setter) {
        super(table, name, getPath, getter, setter);
    }

    public TimeFieldImpl(String table, String name,
                         Supplier<QueryPath> getPath,
                         Supplier<LocalTime> getter,
                         Consumer<LocalTime> setter,
                         LocalTime defaultNow) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public LocalTime getDefaultValue() {
        return LocalTime.MIDNIGHT;
    }
}
