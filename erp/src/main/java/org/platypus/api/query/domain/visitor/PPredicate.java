package org.platypus.api.query.domain.visitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface PPredicate {

    void accept(PredicateVisitor predicateVisitor);

    PPredicate not();

    PPredicate orNull();

}
