package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.BooleanField;

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
public class BooleanFieldImpl extends AbstractFieldImpl<Boolean> implements BooleanField {

    public BooleanFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        super(name,getPath, getter, setter, () ->Boolean.FALSE);
    }
    public BooleanFieldImpl(String name,
                            Supplier<QueryPath> getPath,
                            Supplier<Boolean> getter,
                            Consumer<Boolean> setter,
                            Boolean def) {
        super(name,getPath, getter, setter, () ->def);
    }
}
