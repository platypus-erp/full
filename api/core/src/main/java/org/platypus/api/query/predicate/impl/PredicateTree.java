package org.platypus.api.query.predicate.impl;

import org.platypus.api.query.PredicateCombinator;
import org.platypus.api.query.predicate.PlatypusPredicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public class PredicateTree implements PlatypusPredicate<PredicateTree, PredicateCombinator, PredicateNode> {

    PredicateTree previous;
    PredicateCombinator predicateCombinator;
    PredicateNode current;

    public PredicateTree(PredicateTree previous, PredicateCombinator predicateCombinator, PredicateNode current) {
        this.previous = previous;
        this.predicateCombinator = predicateCombinator;
        this.current = current;
    }

    @Override
    public PredicateTree getLeft() {
        return previous;
    }

    @Override
    public PredicateCombinator getCondition() {
        return predicateCombinator;
    }

    @Override
    public PredicateNode getRight() {
        return current;
    }
}
