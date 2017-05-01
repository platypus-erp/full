package org.platypus.builder.core.views.list.structure.column.stringcol;

import org.platypus.builder.core.views.list.structure.column.AbstractColumn;
import org.platypus.builder.core.views.list.structure.column.ListViewColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewStringColumnImpl extends AbstractColumn implements ListViewStringColumn {

    public ListViewStringColumnImpl() {
        super(ListViewColumn.ColumnType.STRING);
    }
}
