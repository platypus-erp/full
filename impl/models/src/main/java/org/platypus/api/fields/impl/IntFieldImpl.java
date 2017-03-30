package org.platypus.api.fields.impl;

import org.platypus.api.fields.IntField;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class IntFieldImpl<T> extends AbstractFieldImpl<T,Integer> implements IntField {

    public IntFieldImpl(T instance, Function<T, Integer> getter, BiConsumer<T, Integer> setter) {
        super(instance, getter, setter);
    }
}
