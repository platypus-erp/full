package org.platypus.api.query.domain.field;

import org.platypus.api.query.domain.visitor.PPredicate;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface DateTimeFieldPredicate extends ComparableFieldPredicate<LocalDateTime> {

    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate eq(LocalDateTime value) {
        return null;
    }

    @Override
    default PPredicate lessThan(LocalDateTime value) {
        return null;
    }

    @Override
    default PPredicate lessOrEq(LocalDateTime value) {
        return null;
    }

    @Override
    default PPredicate moreThan(LocalDateTime value) {
        return null;
    }

    @Override
    default PPredicate moreOrEq(LocalDateTime value) {
        return null;
    }

    @Override
    default PPredicate between(LocalDateTime value1, LocalDateTime value2) {
        return null;
    }

    @Override
    default PPredicate in(Collection<LocalDateTime> values) {
        return null;
    }

    @Override
    default PPredicate in(LocalDateTime... values) {
        return null;
    }
}
