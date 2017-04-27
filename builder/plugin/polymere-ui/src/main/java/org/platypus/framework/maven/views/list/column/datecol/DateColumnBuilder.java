package org.platypus.framework.maven.views.list.column.datecol;

import org.platypus.framework.maven.views.list.column.ColumnBuilder;
import org.w3c.dom.Element;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class DateColumnBuilder extends ColumnBuilder<ListViewDateColumnImpl>{

    public DateColumnBuilder() {
        super(ListViewDateColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewDateColumnImpl col, Element node) {
        col.setDisplayType(parseDisplay(node.getAttribute("format")));
    }

    private ListViewDateColumn.DisplayType parseDisplay(String displayAttribute){
        if (displayAttribute != null){
            return ListViewDateColumn.DisplayType.fromValue(displayAttribute);
        } else {
            return ListViewDateColumn.DisplayType.NORMAL;
        }
    }
}
