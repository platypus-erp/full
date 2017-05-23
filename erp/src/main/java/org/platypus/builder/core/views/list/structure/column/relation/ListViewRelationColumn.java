package org.platypus.builder.core.views.list.structure.column.relation;

import org.platypus.builder.core.views.list.structure.column.ListViewColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ListViewRelationColumn extends ListViewColumn {
    @Override
    default ColumnType getColumnType() {
        return ColumnType.RELATION;
    }

    String getSubProperty();
    String getPropertyId();
}
