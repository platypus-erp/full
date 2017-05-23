package org.platypus.api.fields.impl;

import org.platypus.api.query.QueryPath;
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


    public LongFieldImpl(String table, String name, Supplier<QueryPath> getPath, Supplier<Long> getter, Consumer<Long> setter) {
        super(table, name, getPath, getter, setter);
    }

    public LongFieldImpl(String table, String name,
                         Supplier<QueryPath> getPath,
                         Supplier<Long> getter,
                         Consumer<Long> setter,
                         Long defaultValue) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public Long getDefaultValue() {
        return 0L;
    }
}
