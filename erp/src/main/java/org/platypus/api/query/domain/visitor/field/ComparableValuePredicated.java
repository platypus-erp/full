package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.ComparableFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.util.Collection;

/**
 * Created by apasquier on 31/05/17.
 */
public abstract class ComparableValuePredicated<T extends Comparable<? super T>, PT extends ComparableFieldPredicate<T>> implements PPredicate {
    PT field;
    DomainPredicate condition;
    T value;
    T value2;
    Collection<T> valuesIn;

    public ComparableValuePredicated(PT field, DomainPredicate condition) {
        this.field = field;
        this.condition = condition;
    }

    public ComparableValuePredicated(PT field, DomainPredicate condition, T value) {
        this.field = field;
        this.condition = condition;
        this.value = value;
    }

    public ComparableValuePredicated(PT field, DomainPredicate condition, T value, T value2) {
        this.field = field;
        this.condition = condition;
        this.value = value;
        this.value2 = value2;
    }

    public ComparableValuePredicated(PT field, DomainPredicate condition, Collection<T> valuesIn) {
        this.field = field;
        this.condition = condition;
        this.valuesIn = valuesIn;
    }

    public PT getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }

    public T getValue() {
        return value;
    }

    public T getValue2() {
        return value2;
    }

    public Collection<T> getValuesIn() {
        return valuesIn;
    }
}
