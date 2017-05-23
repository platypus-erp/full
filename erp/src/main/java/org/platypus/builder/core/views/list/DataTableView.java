package org.platypus.builder.core.views.list;

import org.platypus.builder.core.views.list.structure.ListType;
import org.platypus.builder.core.views.list.structure.PageSize;
import org.platypus.builder.core.views.list.structure.column.ListViewColumn;
import org.platypus.builder.core.views.list.structure.column.boolcol.ListViewBooleanColumn;
import org.platypus.builder.core.views.list.structure.column.currencycol.ListViewCurrencyColumn;
import org.platypus.builder.core.views.list.structure.column.datecol.ListViewDateColumn;
import org.platypus.builder.core.views.list.structure.column.datetimecol.ListViewDateTimeColumn;
import org.platypus.builder.core.views.list.structure.column.floatcol.ListViewFloatColumn;
import org.platypus.builder.core.views.list.structure.column.imgcol.ListViewImgColumn;
import org.platypus.builder.core.views.list.structure.column.integercol.ListViewIntegerColumn;
import org.platypus.builder.core.views.list.structure.column.linkcol.ListViewLinkColumn;
import org.platypus.builder.core.views.list.structure.column.relation.ListViewRelationColumn;
import org.platypus.builder.core.views.list.structure.column.stringcol.ListViewStringColumn;
import org.platypus.builder.core.views.list.structure.column.timecol.ListViewTimeColumn;

import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@SuppressWarnings("unchecked")
public class DataTableView {
    private final String target;
    private final String id;
    private String title;
    private ListType listType;
    private PageSize pageSize;

    private final EnumMap<ListViewColumn.ColumnType, Set<? extends ListViewColumn>> columns = new EnumMap<>(ListViewColumn.ColumnType.class);

    public DataTableView(String target, String id) {
        this.id = id;
        this.target = target;
        this.listType = ListType.PAGINATE;
        this.pageSize = PageSize._40;
        columns.put(ListViewColumn.ColumnType.BOOLEAN, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.CURRENCY, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.DATE, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.DATE_TIME, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.FLOAT, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.IMG, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.INTEGER, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.LINK, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.STRING, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.TIME, new HashSet<>());
        columns.put(ListViewColumn.ColumnType.RELATION, new HashSet<>());
    }

    public String getTitle() {
        return title;
    }

    public DataTableView setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public String getId() {
        return id;
    }

    public ListType getListType() {
        return listType;
    }

    public DataTableView setListType(String listType) {
        this.listType = ListType.valueOf(listType);
        return this;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public DataTableView setPageSize(String pageSize) {
        this.pageSize = PageSize.fromValue(pageSize);
        return this;
    }

    public Set<ListViewBooleanColumn> getBooleanColumns() {
        return (Set<ListViewBooleanColumn>) columns.get(ListViewColumn.ColumnType.BOOLEAN);
    }

    public Set<ListViewStringColumn> getStringColumns() {
        return (Set<ListViewStringColumn>) columns.get(ListViewColumn.ColumnType.STRING);
    }

    public Set<ListViewLinkColumn> getLinkColumns() {
        return (Set<ListViewLinkColumn>) columns.get(ListViewColumn.ColumnType.LINK);
    }

    public Set<ListViewImgColumn> getImgColumns() {
        return (Set<ListViewImgColumn>) columns.get(ListViewColumn.ColumnType.IMG);
    }

    public Set<ListViewDateColumn> getDateColumns() {
        return (Set<ListViewDateColumn>) columns.get(ListViewColumn.ColumnType.DATE);
    }

    public Set<ListViewDateTimeColumn> getDateTimeColumns() {
        return (Set<ListViewDateTimeColumn>) columns.get(ListViewColumn.ColumnType.DATE_TIME);
    }

    public Set<ListViewTimeColumn> getTimeColumns() {
        return (Set<ListViewTimeColumn>) columns.get(ListViewColumn.ColumnType.TIME);
    }

    public Set<ListViewFloatColumn> getFloatColumns() {
        return (Set<ListViewFloatColumn>) columns.get(ListViewColumn.ColumnType.FLOAT);
    }

    public Set<ListViewIntegerColumn> getIntegerColumns() {
        return (Set<ListViewIntegerColumn>) columns.get(ListViewColumn.ColumnType.INTEGER);
    }

    public Set<ListViewCurrencyColumn> getCurrencyColumns() {
        return (Set<ListViewCurrencyColumn>) columns.get(ListViewColumn.ColumnType.CURRENCY);
    }

    public Set<ListViewRelationColumn> getRelationColumns() {
        return (Set<ListViewRelationColumn>) columns.get(ListViewColumn.ColumnType.RELATION);
    }

    public<T extends ListViewColumn> void addColumn(T viewColumn){
        ((Set<T>)columns.get(viewColumn.getColumnType())).add(viewColumn);
    }

    public Set<ListViewColumn> getAllColumns(){
        return columns.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(ListViewColumn::getOrder))
                .collect(toSet());
    }

    private int getNbColumns() {
        return columns.values().stream()
                .collect(summingInt(s -> s.size()));
    }
}
