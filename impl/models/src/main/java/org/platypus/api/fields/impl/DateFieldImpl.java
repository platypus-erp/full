package org.platypus.api.fields.impl;

import org.platypus.api.fields.DateField;

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

    public DateFieldImpl(String name, Supplier<LocalDate> getter, Consumer<LocalDate> setter) {
        super(name, getter, setter);
    }
}
