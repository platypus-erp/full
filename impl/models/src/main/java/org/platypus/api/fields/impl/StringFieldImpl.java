package org.platypus.api.fields.impl;

import org.platypus.api.QueryPath;
import org.platypus.api.fields.StringField;

import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class StringFieldImpl extends AbstractFieldImpl<String> implements StringField {


    public StringFieldImpl(String name, Supplier<QueryPath> getPath, Supplier<String> getter, Consumer<String> setter) {
        super(name,getPath, getter, setter, () ->"");
    }

    public StringFieldImpl(String name,
                           Supplier<QueryPath> getPath,
                           Supplier<String> getter,
                           Consumer<String> setter,
                           String defaultValue) {
        super(name,getPath, getter, setter, () ->defaultValue);
    }

    @Override
    public boolean isEmpty() {
        return getDefaultValue().isEmpty();
    }

    @Override
    public boolean bool() {
        return isNotEmpty();
    }
}
