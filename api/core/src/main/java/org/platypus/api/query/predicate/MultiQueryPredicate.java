package org.platypus.api.query.predicate;

import org.platypus.api.Record;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface MultiQueryPredicate<R extends Record, RF, LF>{

    QueryPredicate<R, LF> getLeft();
    boolean isAnd();
    QueryPredicate<R, RF> getRight();
}
