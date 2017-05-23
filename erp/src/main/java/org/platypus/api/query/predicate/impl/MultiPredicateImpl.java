package org.platypus.api.query.predicate.impl;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.PredicateCombinator;
import org.platypus.api.query.predicate.MultiQueryPredicate;
import org.platypus.api.query.predicate.QueryPredicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/05/17.
 */
public class MultiPredicateImpl<L extends PlatypusField, R extends PlatypusField> implements MultiQueryPredicate<L, R> {

    QueryPredicate<L> left;
    PredicateCombinator sqlPredicate;
    QueryPredicate<R> right;

    public MultiPredicateImpl(QueryPredicate<L> left, PredicateCombinator sqlPredicate, QueryPredicate<R> right) {
        this.left = left;
        this.sqlPredicate = sqlPredicate;
        this.right = right;
    }

    @Override
    public QueryPredicate<L> getLeft() {
        return left;
    }

    @Override
    public PredicateCombinator getCondition() {
        return sqlPredicate;
    }

    @Override
    public QueryPredicate<R> getRight() {
        return right;
    }
}
