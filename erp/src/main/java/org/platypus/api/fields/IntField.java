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
public interface IntField extends PlatypusField<Integer> , ComparableFieldPredicate<Integer>{
    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate eq(Integer value) {
        return null;
    }

    @Override
    default PPredicate lessThan(Integer value) {
        return null;
    }

    @Override
    default PPredicate lessOrEq(Integer value) {
        return null;
    }

    @Override
    default PPredicate moreThan(Integer value) {
        return null;
    }

    @Override
    default PPredicate moreOrEq(Integer value) {
        return null;
    }

    @Override
    default PPredicate between(Integer value1, Integer value2) {
        return null;
    }

    @Override
    default PPredicate in(Collection<Integer> values) {
        return null;
    }

    @Override
    default PPredicate in(Integer... values) {
        return null;
    }
}
