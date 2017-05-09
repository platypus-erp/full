package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.DateField;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DateFieldImpl extends AbstractFieldImpl<LocalDate> implements DateField {

    public DateFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<LocalDate> getter, Consumer<LocalDate> setter) {
        super(name,getPath, getter, setter);
    }
    public DateFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<LocalDate> getter, Consumer<LocalDate> setter,
                         LocalDate def) {
        super(name,getPath, getter, setter);
    }

    @Override
    public LocalDate getDefaultValue() {
        return LocalDate.MIN;
    }
}
