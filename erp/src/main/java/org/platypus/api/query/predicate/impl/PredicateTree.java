package org.platypus.api.query.predicate.impl;

import org.platypus.api.Record;
import org.platypus.api.query.PredicateCombinator;
import org.platypus.api.query.predicate.PlatypusPredicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public class PredicateTree<T extends Record> implements PlatypusPredicate<PredicateTree<T>, PredicateCombinator, PredicateNode<T>> {

    PredicateTree<T> previous;
    PredicateCombinator predicateCombinator;
    PredicateNode<T> current;

    public PredicateTree(PredicateTree<T> previous, PredicateCombinator predicateCombinator, PredicateNode<T> current) {
        this.previous = previous;
        this.predicateCombinator = predicateCombinator;
        this.current = current;
    }

    @Override
    public PredicateTree<T> getLeft() {
        return previous;
    }

    @Override
    public PredicateCombinator getCondition() {
        return predicateCombinator;
    }

    @Override
    public PredicateNode<T> getRight() {
        return current;
    }
}
