package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.TimeField;

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


    public TimeFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<LocalTime> getter, Consumer<LocalTime> setter) {
        super(name, getPath, getter, setter);
    }

    public TimeFieldImpl(String name,
                         Supplier<QueryPath> getPath,
                         Supplier<LocalTime> getter,
                         Consumer<LocalTime> setter,
                         LocalTime defaultNow) {
        super(name, getPath, getter, setter);
    }

    @Override
    public LocalTime getDefaultValue() {
        return LocalTime.MIDNIGHT;
    }
}
