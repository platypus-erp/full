package org.platypus.api.query;

import org.platypus.api.Record;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 16/05/17.
 */
public interface QueryExecutor<T extends Record> {


    long count(QueryBuilder<T> searchBuilder);
    T getFirst(QueryBuilder<T> searchBuilder);
    List<T> get(QueryBuilder<T> searchBuilder);

}
