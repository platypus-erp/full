package org.platypus.api.query.domain.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.field.DateValuePredicate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface DateFieldPredicate extends ComparableFieldPredicate<LocalDate> {

    @Override
    default PPredicate isNull() {
        return new DateValuePredicate(this, DomainPredicate.IS_NULL);
    }

    @Override
    default PPredicate isNotNull() {
        return new DateValuePredicate(this, DomainPredicate.IS_NOT_NULL);
    }

    @Override
    default PPredicate eq(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.EQ, date);
    }

    @Override
    default PPredicate lessThan(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.LESS, date);
    }

    @Override
    default PPredicate lessOrEq(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.LESS_EQ, date);
    }

    @Override
    default PPredicate moreThan(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.MORE, date);
    }

    @Override
    default PPredicate moreOrEq(LocalDate date) {
        return new DateValuePredicate(this, DomainPredicate.MORE_EQ, date);
    }

    @Override
    default PPredicate between(LocalDate date1, LocalDate date2) {
        return new DateValuePredicate(this, DomainPredicate.BETWEEN, date1, date2);
    }

    @Override
    default PPredicate in(Collection values) {
        return new DateValuePredicate(this, DomainPredicate.IN, values);
    }

//    @Override
//    default PPredicate notIn(Collection values) {
//        return new DateValuePredicate(this, DomainPredicate.NOT_IN, values);
//    }

    @Override
    default PPredicate in(LocalDate... values) {
        return new DateValuePredicate(this, DomainPredicate.IN, Arrays.asList(values));
    }

//    @Override
//    default PPredicate notIn(LocalDate... values) {
//        return new DateValuePredicate(this, DomainPredicate.NOT_IN, Arrays.asList(values));
//    }

}
