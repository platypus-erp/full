package org.platypus.api.query;

import org.platypus.api.Pool;
import org.platypus.api.Record;
import org.platypus.erp.manager.impl.SimpleQueryImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author chmuchme
 * @since 0.1
 * on 16/05/17.
 */
public interface QueryExecutor<T extends Record> {


    long count(SimpleQueryImpl<T> searchBuilder);
    Optional<T> getFirst(SimpleQueryImpl<T> searchBuilder);
    List<T> get(SimpleQueryImpl<T> searchBuilder);

    QueryExecutor<T> distinct(boolean distinct);
    QueryExecutor<T> limit(int limit);
    QueryExecutor<T> page(int page);
    QueryExecutor<T> page(int pageNumber, int pageSize);
}
