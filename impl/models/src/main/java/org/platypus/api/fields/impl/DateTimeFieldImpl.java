package org.platypus.api.fields.impl;

import org.platypus.api.fields.DateTimeField;

import java.time.LocalDateTime;
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
public class DateTimeFieldImpl extends AbstractFieldImpl<LocalDateTime> implements DateTimeField {

    public DateTimeFieldImpl(String name, Supplier<LocalDateTime> getter, Consumer<LocalDateTime> setter) {
        super(name, getter, setter);
    }
}
