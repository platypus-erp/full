package org.platypus.api.query.domain.field;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface ComparableFieldPredicate<T extends Comparable<? super T>> extends FieldPredicate, PlatypusField<T>{

    PPredicate<T> eq(T date);
    PPredicate<T> lessThan(T date);
    PPredicate<T> lessOrEq(T date);
    PPredicate<T> moreThan(T date);
    PPredicate<T> moreOrEq(T date);
    PPredicate<T> between(T date1, T date2);
    PPredicate<T> in(Collection<T> values);
    PPredicate<T> notIn(Collection<T> values);

    PPredicate<T> in(T... values);
    PPredicate<T> notIn(T... values);
}
