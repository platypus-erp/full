package org.platypus.api.fields.impl;

import org.platypus.api.fields.FloatField;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FloatFieldImpl extends AbstractFieldImpl<Float> implements FloatField {

    public FloatFieldImpl(Supplier<Float> getter, Consumer<Float> setter) {
        super(getter, setter);
    }
}
