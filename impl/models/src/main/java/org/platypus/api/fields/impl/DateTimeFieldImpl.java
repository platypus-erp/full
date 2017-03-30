package org.platypus.api.fields.impl;

import org.platypus.api.fields.DateTimeField;

import java.time.LocalDateTime;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DateTimeFieldImpl<T> extends AbstractFieldImpl<T,LocalDateTime> implements DateTimeField {

    public DateTimeFieldImpl(T instance, Function<T, LocalDateTime> getter, BiConsumer<T, LocalDateTime> setter) {
        super(instance, getter, setter);
    }
}
