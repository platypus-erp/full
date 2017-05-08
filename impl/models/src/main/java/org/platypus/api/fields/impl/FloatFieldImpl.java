package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.FloatField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FloatFieldImpl extends AbstractFieldImpl<Float> implements FloatField {

    public FloatFieldImpl(String name,
                          Supplier<QueryPath> getPath,
                          Supplier<Float> getter,
                          Consumer<Float> setter) {
        super(name,getPath, getter, setter, () ->0F);
    }
    public FloatFieldImpl(String name,
                          Supplier<QueryPath> getPath,
                          Supplier<Float> getter,
                          Consumer<Float> setter,
                          Float def) {
        super(name,getPath, getter, setter, () ->def);
    }
}
