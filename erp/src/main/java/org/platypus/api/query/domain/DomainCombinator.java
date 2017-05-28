package org.platypus.api.query.domain;

import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 16/05/17.
 */
public enum DomainCombinator implements PPredicate {
    AND,
    OR;

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }


    @Override
    public boolean test(Object o) {
        throw new UnsupportedOperationException("What did you try to do ?");
    }
}
