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

    PPredicate eq(T value);
    PPredicate lessThan(T value);
    PPredicate lessOrEq(T value);
    PPredicate moreThan(T value);
    PPredicate moreOrEq(T value);
    PPredicate between(T value1, T value2);
    PPredicate in(Collection<T> values);
//    PPredicate notIn(Collection<T> values);

    PPredicate in(T... values);
//    PPredicate notIn(T... values);
}
