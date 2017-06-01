package org.platypus.api.fields.impl;

import org.platypus.api.fields.DateTimeField;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.visitor.field.DateTimeProjection;

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

    public DateTimeFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<LocalDateTime> getter, Consumer<LocalDateTime> setter) {
        super(table, name, getPath, getter, setter);
    }

    public DateTimeFieldImpl(String table, String name,
                             Supplier<QueryPath> getPath,
                             Supplier<LocalDateTime> getter,
                             Consumer<LocalDateTime> setter,
                             LocalDateTime def) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public PProjection getProjection() {
        return new DateTimeProjection(this);
    }

    @Override
    public LocalDateTime getDefaultValue() {
        return LocalDateTime.MIN;
    }
}
