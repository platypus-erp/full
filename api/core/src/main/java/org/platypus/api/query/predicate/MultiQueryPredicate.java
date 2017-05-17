package org.platypus.api.query.predicate;

import org.platypus.api.Record;
import org.platypus.api.query.PredicateCombinator;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface MultiQueryPredicate<RF, LF> extends PlatypusPredicate<QueryPredicate<LF>, PredicateCombinator, QueryPredicate<RF>>{
}
