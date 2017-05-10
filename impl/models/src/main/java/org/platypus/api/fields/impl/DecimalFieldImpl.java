package org.platypus.api.fields.impl;

import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.DecimalField;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DecimalFieldImpl extends AbstractFieldImpl<BigDecimal> implements DecimalField {

    public DecimalFieldImpl(String table, String name,
                            Supplier<QueryPath> getPath,
                            Supplier<BigDecimal> getter,
                            Consumer<BigDecimal> setter) {
        super(table, name, getPath, getter, setter);
    }

    public DecimalFieldImpl(String table, String name,
                            Supplier<QueryPath> getPath,
                            Supplier<BigDecimal> getter,
                            Consumer<BigDecimal> setter,
                            BigDecimal def) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public BigDecimal getDefaultValue() {
        return BigDecimal.ZERO;
    }
}
