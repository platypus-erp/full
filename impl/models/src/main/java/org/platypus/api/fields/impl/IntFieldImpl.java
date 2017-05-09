package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
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


    public IntFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<Integer> getter, Consumer<Integer> setter) {
        super(name, getPath, getter, setter);
    }

    public IntFieldImpl(String name,
                        Supplier<QueryPath> getPath,
                        Supplier<Integer> getter,
                        Consumer<Integer> setter,
                        Integer defaultValue) {
        super(name, getPath, getter, setter);
    }

    @Override
    public Integer getDefaultValue() {
        return 0;
    }
}
