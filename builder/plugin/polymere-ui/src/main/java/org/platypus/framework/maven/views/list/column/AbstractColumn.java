package org.platypus.framework.maven.views.list.column;

import org.platypus.framework.maven.views.list.SortableTag;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractColumn implements ListViewColumn {
    private String id;
    private String propertyName;
    private SortableTag sortableTag;
    private String headerLabelKey;
    private int order;
    private boolean actif;
    private final ColumnType columnType;
    private boolean filterable;

    public AbstractColumn(ColumnType columnType) {
        this.columnType = columnType;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public SortableTag getSortableTag() {
        return sortableTag;
    }

    public void setSortableTag(SortableTag sortableTag) {
        this.sortableTag = sortableTag;
    }

    @Override
    public String getHeaderLabelKey() {
        return headerLabelKey;
    }

    public void setHeaderLabelKey(String headerLabelKey) {
        this.headerLabelKey = headerLabelKey;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public boolean isFilterable() {
        return filterable;
    }

    public AbstractColumn setFilterable(boolean filterable) {
        this.filterable = filterable;
        return this;
    }

    @Override
    public ColumnType getColumnType() {
        return columnType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        AbstractColumn that = AbstractColumn.class.cast(o);
        System.out.println(this.getId()+"equals("+that.getId()+") = "+id.equals(that.id));
        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
