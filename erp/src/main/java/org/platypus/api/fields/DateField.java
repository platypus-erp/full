package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.DateFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.field.DateValuePredicate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DateField extends GenericField<LocalDate>, DateFieldPredicate {

    static DateField empty() {
        return null;
    }

    static DateField of(LocalDate value) {
        return null;
    }

    @Override
    default LocalDate getDefaultValue() {
        return LocalDate.MIN;
    }

    @Override
    default PPredicate isNull() {
        return new DateValuePredicate(this, DomainPredicate.IS_NULL);
    }

    @Override
    default PPredicate<LocalDate> isNotNull() {
        return new DateValuePredicate(this, DomainPredicate.IS_NOT_NULL);
    }

    @Override
    default PPredicate<LocalDate> eq(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.EQ, date);
    }

    @Override
    default PPredicate<LocalDate> lessThan(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.LESS, date);
    }

    @Override
    default PPredicate<LocalDate> lessOrEq(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.LESS_EQ, date);
    }

    @Override
    default PPredicate<LocalDate> moreThan(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.MORE, date);
    }

    @Override
    default PPredicate<LocalDate> moreOrEq(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.MORE_EQ, date);
    }

    @Override
    default PPredicate<LocalDate> between(LocalDate date1, LocalDate date2) {
        return new DateValuePredicate(this, DomainPredicate.BETWEEN, date1, date2);
    }

    @Override
    default PPredicate<LocalDate> in(Collection<LocalDate> values) {
        return new DateValuePredicate(this, DomainPredicate.IN, values);
    }

    @Override
    default PPredicate<LocalDate> notIn(Collection<LocalDate> values) {
        return new DateValuePredicate(this, DomainPredicate.NOT_IN, values);
    }

    @Override
    default PPredicate<LocalDate> in(LocalDate... values) {
        return new DateValuePredicate(this, DomainPredicate.IN, Arrays.asList(values));
    }

    @Override
    default PPredicate<LocalDate> notIn(LocalDate... values) {
        return new DateValuePredicate(this, DomainPredicate.NOT_IN, Arrays.asList(values));
    }
}
