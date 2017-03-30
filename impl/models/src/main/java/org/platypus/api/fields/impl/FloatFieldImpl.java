package org.platypus.api.fields.impl;

import org.platypus.api.fields.FloatField;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FloatFieldImpl<T> extends AbstractFieldImpl<T,Float> implements FloatField {

    public FloatFieldImpl(T instance, Function<T, Float> getter, BiConsumer<T, Float> setter) {
        super(instance, getter, setter);
    }
}
