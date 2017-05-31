package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.DateTimeFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DateTimeField extends PlatypusField<LocalDateTime>, DateTimeFieldPredicate {
    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> eq(LocalDateTime date) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> lessThan(LocalDateTime date) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> lessOrEq(LocalDateTime date) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> moreThan(LocalDateTime date) {
        return null;
    }

    @Override
    default LocalDateTime getDefaultValue() {
        return LocalDateTime.MIN;
    }

    @Override
    default PPredicate<LocalDateTime> moreOrEq(LocalDateTime date) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> between(LocalDateTime date1, LocalDateTime date2) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> in(Collection<LocalDateTime> values) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> notIn(Collection<LocalDateTime> values) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> in(LocalDateTime... values) {
        return null;
    }

    @Override
    default PPredicate<LocalDateTime> notIn(LocalDateTime... values) {
        return null;
    }
}
