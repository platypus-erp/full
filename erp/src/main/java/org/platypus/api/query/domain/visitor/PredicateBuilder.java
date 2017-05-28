package org.platypus.api.query.domain.visitor;

import org.platypus.api.query.domain.DomainPredicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class PredicateBuilder {

    private final CriteriaBuilder cb;

    public PredicateBuilder(CriteriaBuilder cb) {
        this.cb = cb;
    }

    public Predicate requiredNonNull(DomainPredicate condition, String field, Predicate pre) {
        if (pre == null) {
            throw new UnsupportedOperationException(
                    "The domain " + condition + " is not Supported for the aggregate" + field);
        }
        return pre;
    }

    public Predicate getPredicateNullOrNotNull(Path<?> path1, DomainPredicate condition) {
        switch (condition) {
            case IS_NULL:
                return cb.isNull(path1);
            case IS_NOT_NULL:
                return cb.isNotNull(path1);
            default:
                return null;
        }
    }

    public Predicate getPredicateEq(Path<?> path1, DomainPredicate condition, Object value) {
        switch (condition) {
            case EQ:
                return cb.equal(path1, value);
            case NOT_EQ:
                return cb.notEqual(path1, value);
            default:
                return null;
        }

    }

    public <Y extends Comparable<? super Y>> Predicate getPredicateComparable(Path<Y> path1,
                                                                              DomainPredicate condition,
                                                                              Y value1, Y value2) {
        Predicate pre = getPredicateNullOrNotNull(path1, condition);
        if (pre != null) {
            return pre;
        }
        pre = getPredicateEq(path1, condition, value1);
        if (pre != null) {
            return pre;
        }
        switch (condition) {
            case LESS:
                return cb.lessThan(path1, value1);
            case LESS_EQ:
                return cb.lessThanOrEqualTo(path1, value1);
            case MORE:
                return cb.greaterThan(path1, value1);
            case MORE_EQ:
                return cb.greaterThanOrEqualTo(path1, value1);
            case BETWEEN:
                return cb.between(path1, value1, value2);
            default:
                return null;
        }
    }

    public <Y> Predicate getPredicateIn(Path<Y> path1, DomainPredicate condition, Collection<? extends Y> values) {
        Predicate pre = getPredicateNullOrNotNull(path1, condition);
        if (pre != null) {
            return pre;
        }
        switch (condition){
            case IN:
                return path1.in(condition);
            case NOT_IN:
                return path1.in(condition).not();
            default:
                return null;
        }
    }
}
