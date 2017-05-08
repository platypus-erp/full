package org.platypus.api.fields.impl;

import org.platypus.api.fields.BinaryField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BinaryFieldImpl extends AbstractFieldImpl<byte[]> implements BinaryField {

    public BinaryFieldImpl(String name, Supplier<byte[]> getter, Consumer<byte[]> setter) {
        super(name, getter, setter);
    }
}
