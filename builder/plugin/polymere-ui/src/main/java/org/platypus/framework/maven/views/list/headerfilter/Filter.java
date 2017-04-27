package org.platypus.framework.maven.views.list.headerfilter;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class Filter {
    private final String filterId;
    private final String label;

    public Filter(String filterId, String label) {
        this.filterId = filterId;
        this.label = label;
    }

    public String getFilterId() {
        return filterId;
    }

    public String getLabel() {
        return label;
    }
}
