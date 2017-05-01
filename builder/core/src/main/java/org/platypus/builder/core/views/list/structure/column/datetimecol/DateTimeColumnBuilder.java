package org.platypus.builder.core.views.list.structure.column.datetimecol;

import org.platypus.builder.core.views.list.structure.column.ColumnBuilder;
import org.w3c.dom.Element;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class DateTimeColumnBuilder extends ColumnBuilder<ListViewDateTimeColumnImpl> {

    public DateTimeColumnBuilder() {
        super(ListViewDateTimeColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewDateTimeColumnImpl col, Element node) {
        col.setDisplayType(parseDisplay(node.getAttribute("format")));
    }

    private ListViewDateTimeColumn.DisplayType parseDisplay(String displayAttribute) {
        if (displayAttribute != null) {
            return ListViewDateTimeColumn.DisplayType.fromValue(displayAttribute);
        } else {
            return ListViewDateTimeColumn.DisplayType.SHORT;
        }
    }
}
