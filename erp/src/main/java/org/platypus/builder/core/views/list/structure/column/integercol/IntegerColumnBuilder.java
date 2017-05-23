package org.platypus.builder.core.views.list.structure.column.integercol;

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
public class IntegerColumnBuilder extends ColumnBuilder<ListViewIntegerColumnImpl> {

    public IntegerColumnBuilder() {
        super(ListViewIntegerColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewIntegerColumnImpl col, Element node) {

    }
}
