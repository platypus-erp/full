package org.platypus.api.fields.impl;

import org.platypus.api.fields.LongField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class LongFieldImpl extends AbstractFieldImpl<Long> implements LongField {

    public LongFieldImpl(String name, Supplier<Long> getter, Consumer<Long> setter) {
        super(name, getter, setter);
    }
}
