package org.platypus.framework.maven.views.list.headerfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class HeaderFilter {

    private final List<Filter> filters = new ArrayList<>();
    private final List<GroupFilter> groupFilters = new ArrayList<>();

    public HeaderFilter addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }
    public HeaderFilter addGroupFilter(GroupFilter groupFilter) {
        this.groupFilters.add(groupFilter);
        return this;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public List<GroupFilter> getGroupFilters() {
        return groupFilters;
    }
}
