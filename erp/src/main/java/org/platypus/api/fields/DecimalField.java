package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.ComparableFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DecimalField extends PlatypusField<BigDecimal>, ComparableFieldPredicate<BigDecimal> {


    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate eq(BigDecimal value) {
        return null;
    }

    @Override
    default PPredicate lessThan(BigDecimal value) {
        return null;
    }

    @Override
    default PPredicate lessOrEq(BigDecimal value) {
        return null;
    }

    @Override
    default PPredicate moreThan(BigDecimal value) {
        return null;
    }

    @Override
    default PPredicate moreOrEq(BigDecimal value) {
        return null;
    }

    @Override
    default PPredicate between(BigDecimal value1, BigDecimal value2) {
        return null;
    }

    @Override
    default PPredicate in(Collection<BigDecimal> values) {
        return null;
    }

    @Override
    default PPredicate in(BigDecimal... values) {
        return null;
    }
}
