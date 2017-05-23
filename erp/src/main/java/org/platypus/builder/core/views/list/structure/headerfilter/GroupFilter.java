package org.platypus.builder.core.views.list.structure.headerfilter;

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
public class GroupFilter {
//    label="Groupe 1" label-position="right"
    private final String label;
    private final LabelPosition labelPosition;
    private final List<Filter> filters = new ArrayList<>();

    public enum LabelPosition{
        LEFT,RIGHT,TOP
    }

    public GroupFilter(String label, String labelPosition) {
        this.label = label;
        this.labelPosition = LabelPosition.valueOf(labelPosition.toUpperCase());
    }

    public GroupFilter addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public String getLabel() {
        return label;
    }

    public LabelPosition getLabelPosition() {
        return labelPosition;
    }
}
