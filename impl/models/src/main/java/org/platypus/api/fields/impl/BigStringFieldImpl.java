package org.platypus.api.fields.impl;

import org.platypus.api.fields.BigStringField;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BigStringFieldImpl<T> extends AbstractFieldImpl<T,String> implements BigStringField {

    public BigStringFieldImpl(T instance, Function<T, String> getter, BiConsumer<T, String> setter) {
        super(instance, getter, setter);
    }
}
