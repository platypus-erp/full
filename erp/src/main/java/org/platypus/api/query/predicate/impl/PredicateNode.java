package org.platypus.api.query.predicate.impl;

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
public class PredicateNode<R extends Record> implements PlatypusPredicate<Function<R, QueryPredicate<?>>, PredicateCombinator, PredicateNode> {

    Function<R, QueryPredicate<?>> current;
    PredicateCombinator predicateCombinator;
    PredicateNode<R> next;

    public PredicateNode(Function<R, QueryPredicate<?>> current, PredicateCombinator predicateCombinator, PredicateNode<R> next) {
        this.current = current;
        this.predicateCombinator = predicateCombinator;
        this.next = next;
    }

    public PredicateNode(Function<R, QueryPredicate<?>> current, PredicateCombinator predicateCombinator, Function<R, QueryPredicate<?>> next) {
        this.current = current;
        this.predicateCombinator = predicateCombinator;
        this.next = new PredicateNode<>(next);
    }

    public PredicateNode(Function<R, QueryPredicate<?>> current) {
        this.current = current;
        this.predicateCombinator = null;
        this.next = null;
    }

    @Override
    public Function<R, QueryPredicate<?>> getLeft() {
        return current;
    }

    @Override
    public PredicateCombinator getCondition() {
        return predicateCombinator;
    }

    @Override
    public PredicateNode getRight() {
        return next;
    }
}
