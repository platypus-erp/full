package org.platypus.builder.core.views.list.structure.column.currencycol;

import j2html.tags.ContainerTag;
import org.platypus.builder.core.views.list.structure.column.AbstractColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewCurrencyColumnImpl extends AbstractColumn implements ListViewCurrencyColumn {
    public ListViewCurrencyColumnImpl() {
        super(ColumnType.CURRENCY);
    }

    @Override
    public ContainerTag toContainerTag() {
        return null;
    }
}
