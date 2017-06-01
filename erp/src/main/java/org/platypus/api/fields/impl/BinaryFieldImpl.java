package org.platypus.api.fields.impl;

import org.platypus.api.fields.BinaryField;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.field.BinaryValuePredicate;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.visitor.field.BinaryProjection;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BinaryFieldImpl extends AbstractFieldImpl<byte[]> implements BinaryField {

    public BinaryFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<byte[]> getter, Consumer<byte[]> setter) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public byte[] getDefaultValue() {
        return new byte[0];
    }

    @Override
    public PPredicate isNotNull() {
        return new BinaryValuePredicate(this, DomainPredicate.IS_NOT_NULL);
    }

    @Override
    public PProjection getProjection() {
        return new BinaryProjection(this);
    }

    @Override
    public PPredicate isNull() {
        return new BinaryValuePredicate(this, DomainPredicate.IS_NULL);
    }
}
