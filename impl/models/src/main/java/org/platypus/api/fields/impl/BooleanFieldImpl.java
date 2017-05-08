package org.platypus.api.fields.impl;

import org.platypus.api.fields.BooleanField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BooleanFieldImpl extends AbstractFieldImpl<Boolean> implements BooleanField {

    public BooleanFieldImpl(String name, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        super(name, getter, setter);
    }
}
