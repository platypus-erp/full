package org.platypus.api.fields.impl;

import org.platypus.api.fields.DecimalField;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DecimalFieldImpl<T> extends AbstractFieldImpl<T,BigDecimal> implements DecimalField {

    public DecimalFieldImpl(T instance, Function<T, BigDecimal> getter, BiConsumer<T, BigDecimal> setter) {
        super(instance, getter, setter);
    }
}
