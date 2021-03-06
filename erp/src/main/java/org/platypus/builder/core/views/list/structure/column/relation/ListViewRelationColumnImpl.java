package org.platypus.builder.core.views.list.structure.column.relation;

import j2html.tags.ContainerTag;
import org.apache.commons.lang3.StringUtils;
import org.platypus.builder.core.views.list.structure.column.AbstractColumn;

import static org.platypus.builder.core.views.list.structure.column.ListViewColumn.ColumnType.RELATION;

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
        this.subProperty = StringUtils.defaultIfBlank(subProperty, "methodName");
        return this;
    }

    @Override
    public String getPropertyId() {
        return null;
    }

    @Override
    public ContainerTag toContainerTag() {
        return null;
    }
}
