package org.platypus.api.fields.impl;

import org.platypus.api.query.QueryPath;
import org.platypus.api.query.tmp.QueryPathImpl;
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

    public FloatFieldImpl(String table, String name,
                          Supplier<QueryPath> getPath,
                          Supplier<Float> getter,
                          Consumer<Float> setter) {
        super(table, name, getPath, getter, setter);
    }

    public FloatFieldImpl(String table, String name,
                          Supplier<QueryPath> getPath,
                          Supplier<Float> getter,
                          Consumer<Float> setter,
                          Float def) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public Float getDefaultValue() {
        return 0F;
    }
}
