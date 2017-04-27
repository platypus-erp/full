package org.platypus.framework.maven.views.list.column.boolcol;

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
public class ListViewBooleanColumnImpl extends AbstractColumn implements ListViewBooleanColumn {
    private boolean toggleDisplayed;

    public ListViewBooleanColumnImpl() {
        super(ListViewColumn.ColumnType.BOOLEAN);
    }

    @Override
    public boolean isToggleDisplayed() {
        return toggleDisplayed;
    }

    public void setToggleDisplayed(boolean toggleDisplayed) {
        this.toggleDisplayed = toggleDisplayed;
    }

    @Override
    public ListViewColumn.ColumnType getColumnType() {
        return ListViewColumn.ColumnType.BOOLEAN;
    }


}
