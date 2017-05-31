package org.platypus.api.query.domain.visitor.domain;

import org.platypus.api.query.Domain;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class GroupDomain implements PPredicate {
    PPredicate predicate;
    Domain.DomainCombinator combinator;
    PPredicate next;

    public PPredicate getPredicate() {
        return predicate;
    }

    public Domain.DomainCombinator getCombinator() {
        return combinator;
    }

    public PPredicate getNext() {
        return next;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
