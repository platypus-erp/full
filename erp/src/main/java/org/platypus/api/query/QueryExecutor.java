package org.platypus.api.query;

import org.platypus.api.Record;

import java.util.List;
import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 16/05/17.
 */
public interface QueryExecutor<T extends Record> {


    long count(SimpleQuery<T> searchBuilder);
    Optional<T> getFirst(SimpleQuery<T> searchBuilder);
    List<T> get(SimpleQuery<T> searchBuilder);

    QueryExecutor<T> distinct(boolean distinct);
    QueryExecutor<T> limit(int limit);
    QueryExecutor<T> page(int page);
    QueryExecutor<T> page(int pageNumber, int pageSize);
}
