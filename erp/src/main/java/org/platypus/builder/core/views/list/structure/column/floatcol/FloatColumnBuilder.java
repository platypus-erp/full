package org.platypus.builder.core.views.list.structure.column.floatcol;

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
public class FloatColumnBuilder extends ColumnBuilder<ListViewFloatColumnImpl>{

    public FloatColumnBuilder() {
        super(ListViewFloatColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewFloatColumnImpl col, Element node) {

    }
}
