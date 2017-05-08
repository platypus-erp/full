package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.BigStringField;

import java.math.BigDecimal;
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

    public BigStringFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<String> getter, Consumer<String> setter) {
        super(name,getPath, getter, setter, () ->"");
    }
}
