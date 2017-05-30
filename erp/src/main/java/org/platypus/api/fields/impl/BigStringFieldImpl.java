package org.platypus.api.fields.impl;

import org.platypus.api.fields.BigStringField;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.field.BigStringValuePredicate;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BigStringFieldImpl extends AbstractFieldImpl<String> implements BigStringField {

    public BigStringFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<String> getter, Consumer<String> setter) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public String getDefaultValue() {
        return "";
    }

    @Override
    public PPredicate<String> isNotNull() {
        return new BigStringValuePredicate(this, DomainPredicate.IS_NOT_NULL);
    }

    @Override
    public PPredicate<String> isNull() {
        return new BigStringValuePredicate(this, DomainPredicate.IS_NOT_NULL);
    }
}
