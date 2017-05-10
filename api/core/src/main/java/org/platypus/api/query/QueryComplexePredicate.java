package org.platypus.api.query;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface QueryComplexePredicate {

    QueryPredicate left();

    boolean isAndCondition();

    QueryPredicate right();
}
