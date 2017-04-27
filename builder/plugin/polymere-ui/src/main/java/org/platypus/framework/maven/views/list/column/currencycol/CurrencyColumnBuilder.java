package org.platypus.framework.maven.views.list.column.currencycol;

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
public class CurrencyColumnBuilder extends ColumnBuilder<ListViewCurrencyColumnImpl> {

    public CurrencyColumnBuilder() {
        super(ListViewCurrencyColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewCurrencyColumnImpl col, Element node) {
    }
}
