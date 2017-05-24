package org.platypus.api.query.predicate.impl;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.query.PredicateCombinator;
import org.platypus.api.query.predicate.PlatypusPredicate;
import org.platypus.api.query.predicate.QueryPredicate;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public class PredicateHolder<R extends Record> implements
        PlatypusPredicate<
                Function<R, QueryPredicate<? extends PlatypusField<?>>>,
                PredicateCombinator,
                PredicateHolder<R>> {

    Function<R, QueryPredicate<? extends PlatypusField<?>>> current;
    PredicateCombinator predicateCombinator;
    PredicateHolder<R> next;

    public PredicateHolder(Function<R, QueryPredicate<? extends PlatypusField<?>>> current,
                           PredicateCombinator predicateCombinator,
                           PredicateHolder<R> next) {
        this.current = current;
        this.predicateCombinator = predicateCombinator;
        this.next = next;
    }

    public PredicateHolder(Function<R, QueryPredicate<? extends PlatypusField<?>>> current,
                           PredicateCombinator predicateCombinator,
                           Function<R, QueryPredicate<?extends PlatypusField<?>>> next) {
        this.current = current;
        this.predicateCombinator = predicateCombinator;
        this.next = new PredicateHolder<>(next);
    }

    public PredicateHolder(Function<R, QueryPredicate<? extends PlatypusField<?>>> current) {
        this.current = current;
        this.predicateCombinator = null;
        this.next = null;
    }

    @Override
    public Function<R, QueryPredicate<? extends PlatypusField<?>>> getLeft() {
        return current;
    }

    @Override
    public PredicateCombinator getCondition() {
        return predicateCombinator;
    }

    @Override
    public PredicateHolder<R> getRight() {
        return next;
    }
}
