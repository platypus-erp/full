package org.platypus.framework.maven.views.list.column.stringcol;

import org.platypus.framework.maven.views.list.column.AbstractColumn;
import org.platypus.framework.maven.views.list.column.ListViewColumn;

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
