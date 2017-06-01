package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.ComparableFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.time.LocalTime;
import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface TimeField extends PlatypusField<LocalTime>, ComparableFieldPredicate<LocalTime> {

    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate eq(LocalTime value) {
        return null;
    }

    @Override
    default PPredicate lessThan(LocalTime value) {
        return null;
    }

    @Override
    default PPredicate lessOrEq(LocalTime value) {
        return null;
    }

    @Override
    default PPredicate moreThan(LocalTime value) {
        return null;
    }

    @Override
    default PPredicate moreOrEq(LocalTime value) {
        return null;
    }

    @Override
    default PPredicate between(LocalTime value1, LocalTime value2) {
        return null;
    }

    @Override
    default PPredicate in(Collection<LocalTime> values) {
        return null;
    }

    @Override
    default PPredicate in(LocalTime... values) {
        return null;
    }
}
