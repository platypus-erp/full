package org.platypus.builder.core.views.list.structure.column.boolcol;

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
public class BooleanColumnBuilder extends ColumnBuilder<ListViewBooleanColumnImpl> {

    public BooleanColumnBuilder() {
        super(ListViewBooleanColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewBooleanColumnImpl col, Element node) {
        col.setToggleDisplayed(parseDisplay(node.getAttribute("display")));
    }

    private boolean parseDisplay(String displayAttribute){
        return ((displayAttribute != null) && displayAttribute.equals("toggle"));
    }
}
