package org.platypus.api.fields.impl;

import org.platypus.api.fields.StringField;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.visitor.field.StringProjection;

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


    public StringFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<String> getter, Consumer<String> setter) {
        super(table, name, getPath, getter, setter);
    }

    public StringFieldImpl(String table, String name,
                           Supplier<QueryPath> getPath,
                           Supplier<String> getter,
                           Consumer<String> setter,
                           String defaultValue) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public PProjection getProjection() {
        return new StringProjection(this);
    }

    @Override
    public String getDefaultValue() {
        return "";
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
