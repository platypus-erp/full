package org.platypus.framework.maven.views.list.column.relation;

import org.platypus.framework.maven.views.list.column.AbstractColumn;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.platypus.framework.maven.views.list.column.ListViewColumn.ColumnType.RELATION;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewRelationColumnImpl extends AbstractColumn implements ListViewRelationColumn {
    private String subProperty;

    public ListViewRelationColumnImpl() {
        super(RELATION);
    }

    @Override
    public String getSubProperty() {
        return subProperty;
    }

    public ListViewRelationColumnImpl setSubProperty(String subProperty) {
        this.subProperty = defaultIfBlank(subProperty, "name");
        return this;
    }

    @Override
    public String getPropertyId() {
        return null;
    }
}
