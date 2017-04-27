package org.platypus.framework.maven.views.list.column.datecol;

import org.platypus.framework.maven.views.list.column.AbstractColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewDateColumnImpl extends AbstractColumn implements ListViewDateColumn {

    public ListViewDateColumnImpl() {
        super(ColumnType.DATE);
    }

    private DisplayType displayType;

    @Override
    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }
}
