package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.DateTimeField;

import java.math.BigDecimal;
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

    public DateTimeFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<LocalDateTime> getter, Consumer<LocalDateTime> setter) {
        super(name,getPath, getter, setter,() ->LocalDateTime.MIN);
    }
    public DateTimeFieldImpl(String name,
                             Supplier<QueryPath> getPath,
                             Supplier<LocalDateTime> getter,
                             Consumer<LocalDateTime> setter,
                             LocalDateTime def) {
        super(name,getPath, getter, setter, () ->def);
    }
}
