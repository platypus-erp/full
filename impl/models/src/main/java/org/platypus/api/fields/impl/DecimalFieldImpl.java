package org.platypus.api.fields.impl;

import org.platypus.api.fields.DecimalField;

import java.math.BigDecimal;
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
public class DecimalFieldImpl extends AbstractFieldImpl<BigDecimal> implements DecimalField {

    public DecimalFieldImpl(Supplier<BigDecimal> getter, Consumer<BigDecimal> setter) {
        super(getter, setter);
    }
}
