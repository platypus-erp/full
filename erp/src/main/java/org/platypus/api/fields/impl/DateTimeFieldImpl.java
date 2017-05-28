package org.platypus.api.fields.impl;

import org.platypus.api.query.tmp.QueryPathImpl;
import org.platypus.api.fields.DateTimeField;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DateTimeFieldImpl extends AbstractFieldImpl<LocalDateTime> implements DateTimeField {

    public DateTimeFieldImpl(String table, String name, Supplier<QueryPathImpl> getPath, Supplier<LocalDateTime> getter, Consumer<LocalDateTime> setter) {
        super(table, name, getPath, getter, setter);
    }

    public DateTimeFieldImpl(String table, String name,
                             Supplier<QueryPathImpl> getPath,
                             Supplier<LocalDateTime> getter,
                             Consumer<LocalDateTime> setter,
                             LocalDateTime def) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public LocalDateTime getDefaultValue() {
        return LocalDateTime.MIN;
    }
}
