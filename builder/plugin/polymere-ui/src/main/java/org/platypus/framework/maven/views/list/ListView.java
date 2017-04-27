package org.platypus.framework.maven.views.list;

import org.platypus.framework.maven.freemarker.RootFreeMarker;
import org.platypus.framework.maven.views.list.column.ListViewColumn;
import org.platypus.framework.maven.views.list.headerfilter.HeaderFilter;

import static org.apache.commons.lang3.StringUtils.defaultString;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListView implements RootFreeMarker {

    private final String target;
    private final String id;
    private String title;
    private String defaultFilterId;
    private DataTableView dataTableView;
    private HeaderFilter headerFilter;

    public ListView(String target, String id) {
        this.target = target;
        this.id = id;
    }

    public ListView setDataTableView(DataTableView dataTableView) {
        this.dataTableView = dataTableView;
        this.title = dataTableView.getTitle();
        return this;
    }

    public DataTableView getDataTableView() {
        return dataTableView;
    }

    public HeaderFilter getHeaderFilter() {
        return headerFilter;
    }

    public ListView setHeaderFilter(HeaderFilter headerFilter) {
        this.headerFilter = headerFilter;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ListView setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDefaultFilterId() {
        return defaultFilterId;
    }

    public ListView setDefaultFilterId(String defaultFilterId) {
        this.defaultFilterId = defaultString(defaultFilterId, "DEFAULT");
        return this;
    }

    public<T extends ListViewColumn> ListView addColumn(T viewColumn){
        dataTableView.addColumn(viewColumn);
        return this;
    }
}
