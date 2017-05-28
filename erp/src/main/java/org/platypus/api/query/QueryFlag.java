package org.platypus.api.query;

import org.platypus.api.Record;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface QueryFlag<R extends Record> {

    QueryFlag<R> distinct(boolean distinct);
    QueryFlag<R> limit(int limit);
    QueryFlag<R> pageSize(int pageSize);
    QueryFlag<R> page(int page);
    QueryOrder<R> page(int pageNumber, int pageSize);


    int getLimit();
    int getPageSize();
    int getPageNum();
    boolean isDistinct();
}
