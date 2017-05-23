package org.platypus.api.fields.impl;

import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.BooleanField;

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
    public Boolean getDefaultValue() {
        return Boolean.FALSE;
    }
}
