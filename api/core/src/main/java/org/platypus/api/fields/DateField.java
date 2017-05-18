package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.query.SqlPredicate;
import org.platypus.api.query.predicate.impl.PredicateImpl;
import org.platypus.api.query.predicate.QueryPredicate;

import java.time.LocalDate;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DateField extends GenericField<LocalDate> {

    default QueryPredicate<DateField> isNull() {
        return new PredicateImpl<>(this, SqlPredicate.IS_NULL, empty());
    }

    default QueryPredicate<DateField> isNotNull() {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, empty());
    }

    default QueryPredicate<DateField> less(LocalDate than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, of(than));
    }

    default QueryPredicate<DateField> less(DateField than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, than);
    }

    default QueryPredicate<DateField> lessOrEqual(LocalDate than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, of(than));
    }

    default QueryPredicate<DateField> lessOrEqual(DateField than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, than);
    }

    default QueryPredicate<DateField> more(LocalDate than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, of(than));
    }

    default QueryPredicate<DateField> more(DateField than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, than);
    }

    default QueryPredicate<DateField> moreOrEqual(LocalDate than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, of(than));
    }

    default QueryPredicate<DateField> moreOrEqual(DateField than) {
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, than);
    }

    static DateField empty() {
        return null;
    }

    static DateField of(LocalDate value) {
        return null;
    }
}
