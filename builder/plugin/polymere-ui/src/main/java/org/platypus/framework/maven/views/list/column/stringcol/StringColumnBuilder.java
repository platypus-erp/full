package org.platypus.framework.maven.views.list.column.stringcol;

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
public class StringColumnBuilder extends ColumnBuilder<ListViewStringColumnImpl>{

    public StringColumnBuilder() {
        super(ListViewStringColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewStringColumnImpl col, Element node) {

    }
}
