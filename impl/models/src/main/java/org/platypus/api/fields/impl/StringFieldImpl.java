package org.platypus.api.fields.impl;

import org.platypus.api.fields.StringField;

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
public class StringFieldImpl extends AbstractFieldImpl<String> implements StringField {

    public StringFieldImpl(String name, Supplier<String> getter, Consumer<String> setter) {
        super(name, getter, setter);
    }
}
