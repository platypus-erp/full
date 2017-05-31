package org.platypus.builder.core.views.list.structure;

import org.apache.commons.lang3.StringUtils;
import org.platypus.builder.core.views.list.DataTableView;
import org.platypus.builder.core.views.list.structure.column.ListViewColumn;
import org.platypus.builder.core.views.list.structure.headerfilter.HeaderFilter;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListView {

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
        this.defaultFilterId = StringUtils.defaultString(defaultFilterId, "DEFAULT");
        return this;
    }

    public<T extends ListViewColumn> ListView addColumn(T viewColumn){
        dataTableView.addColumn(viewColumn);
        return this;
    }

    @Override
    public String toString() {
        return "ListView{" +
                "target='" + target + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", defaultFilterId='" + defaultFilterId + '\'' +
                ", dataTableView=" + dataTableView +
                ", headerFilter=" + headerFilter +
                '}';
    }
}
