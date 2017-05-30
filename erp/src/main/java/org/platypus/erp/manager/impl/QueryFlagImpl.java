package org.platypus.erp.manager.impl;

/**
 * @author chmuchme
 * @since 0.1
 * on 28/05/17.
 */
public class QueryFlagImpl {

    public int getLimit() {
        return 0;
    }

    public int getPageSize() {
        return 0;
    }

    public int getPageNum() {
        return 0;
    }

    public QueryFlagImpl distinct(boolean distinct) {
        return this;
    }

    public QueryFlagImpl limit(int limit) {
        return null;
    }

    public QueryFlagImpl pageSize(int pageSize) {
        return null;
    }

    public QueryFlagImpl page(int page) {
        return null;
    }

    public QueryFlagImpl page(int pageNumber, int pageSize) {
        return null;
    }

    public boolean isDistinct() {
        return false;
    }
}
