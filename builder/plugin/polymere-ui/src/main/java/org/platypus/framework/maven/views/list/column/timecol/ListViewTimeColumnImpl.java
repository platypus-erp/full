package org.platypus.framework.maven.views.list.column.timecol;

import org.platypus.framework.maven.views.list.column.ListViewColumn;
import org.platypus.framework.maven.views.list.column.AbstractColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewTimeColumnImpl extends AbstractColumn implements ListViewTimeColumn{

    private boolean secondDisplayed;

    public ListViewTimeColumnImpl() {
        super(ColumnType.TIME);
    }

    @Override
    public ColumnType getColumnType() {
        return ListViewColumn.ColumnType.TIME;
    }

    @Override
    public boolean isSecondDisplayed() {
        return secondDisplayed;
    }

    public void setSecondDisplayed(boolean secondDisplayed) {
        this.secondDisplayed = secondDisplayed;
    }
}
