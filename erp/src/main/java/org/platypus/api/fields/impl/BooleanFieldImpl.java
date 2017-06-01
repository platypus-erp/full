package org.platypus.api.fields.impl;

import org.platypus.api.fields.BooleanField;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.field.BooleanValuePredicate;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.visitor.field.BooleanProjection;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BooleanFieldImpl extends AbstractFieldImpl<Boolean> implements BooleanField {

    public BooleanFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        super(table, name, getPath, getter, setter);
    }

    public BooleanFieldImpl(String table, String name,
                            Supplier<QueryPath> getPath,
                            Supplier<Boolean> getter,
                            Consumer<Boolean> setter,
                            Boolean def) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public PProjection getProjection() {
        return new BooleanProjection(this);
    }

    @Override
    public PPredicate eq(Boolean value) {
        return value ? isTrue() : isFalse();
    }

    @Override
    public PPredicate isTrue() {
        return BooleanValuePredicate.isTrue(this);
    }

    @Override
    public PPredicate isFalse() {
        return BooleanValuePredicate.isFalse(this);
    }

    @Override
    public Boolean getDefaultValue() {
        return Boolean.FALSE;
    }
}
