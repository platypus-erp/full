package org.platypus.api.fields.impl;

import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.BigStringField;

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
}
