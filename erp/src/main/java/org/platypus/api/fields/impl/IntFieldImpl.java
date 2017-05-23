package org.platypus.api.fields.impl;

import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.IntField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class IntFieldImpl extends AbstractFieldImpl<Integer> implements IntField {


    public IntFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<Integer> getter, Consumer<Integer> setter) {
        super(table, name, getPath, getter, setter);
    }

    public IntFieldImpl(String table, String name,
                        Supplier<QueryPath> getPath,
                        Supplier<Integer> getter,
                        Consumer<Integer> setter,
                        Integer defaultValue) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public Integer getDefaultValue() {
        return 0;
    }
}