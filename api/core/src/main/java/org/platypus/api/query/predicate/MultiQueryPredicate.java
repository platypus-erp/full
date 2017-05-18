package org.platypus.api.query.predicate;

import org.platypus.api.Record;
import org.platypus.api.query.PredicateCombinator;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface MultiQueryPredicate<L, R> extends PlatypusPredicate<QueryPredicate<L>, PredicateCombinator, QueryPredicate<R>>{
}
