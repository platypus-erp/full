package org.platypus.api.fields.impl;

import org.platypus.api.fields.BinaryField;

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
public class BinaryFieldImpl extends AbstractFieldImpl<byte[]> implements BinaryField {

    public BinaryFieldImpl(Supplier<byte[]> getter, Consumer<byte[]> setter) {
        super(getter, setter);
    }
}
