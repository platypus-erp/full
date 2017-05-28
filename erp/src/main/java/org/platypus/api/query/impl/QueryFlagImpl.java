package org.platypus.api.query.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.platypus.api.Record;
import org.platypus.api.query.QueryFlag;
import org.platypus.api.query.QueryOrder;

/**
 * @author chmuchme
 * @since 0.1
 * on 28/05/17.
 */
public class QueryFlagImpl<R extends Record> implements QueryFlag<R> {

    @Override
    public int getLimit() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public int getPageNum() {
        return 0;
    }

    @Override
    public QueryFlag<R> distinct(boolean distinct) {
        return this;
    }

    @Override
    public QueryFlag<R> limit(int limit) {
        return null;
    }

    @Override
    public QueryFlag<R> pageSize(int pageSize) {
        return null;
    }

    @Override
    public QueryFlag<R> page(int page) {
        return null;
    }

    @Override
    public QueryOrder<R> page(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public boolean isDistinct() {
        return false;
    }
}
