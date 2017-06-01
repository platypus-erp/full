package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.ComparableFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface FloatField extends PlatypusField<Float>, ComparableFieldPredicate<Float> {
    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate eq(Float value) {
        return null;
    }

    @Override
    default PPredicate lessThan(Float value) {
        return null;
    }

    @Override
    default PPredicate lessOrEq(Float value) {
        return null;
    }

    @Override
    default PPredicate moreThan(Float value) {
        return null;
    }

    @Override
    default PPredicate moreOrEq(Float value) {
        return null;
    }

    @Override
    default PPredicate between(Float value1, Float value2) {
        return null;
    }

    @Override
    default PPredicate in(Collection<Float> values) {
        return null;
    }

    @Override
    default PPredicate in(Float... values) {
        return null;
    }
}
