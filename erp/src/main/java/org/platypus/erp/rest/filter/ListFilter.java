package org.platypus.erp.rest.filter;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListFilter {

    private final int page;
    private final int pageSize;
    private final String filterId;

    public ListFilter(int page, int pageSize, String filterId) {
        this.page = page;
        this.pageSize = pageSize;
        this.filterId = filterId;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Filter getFilterId() {
        return null;
    }
}
