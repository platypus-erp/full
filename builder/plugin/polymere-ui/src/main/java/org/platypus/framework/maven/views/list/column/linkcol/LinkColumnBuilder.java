package org.platypus.framework.maven.views.list.column.linkcol;

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
public class LinkColumnBuilder extends ColumnBuilder<ListViewLinkColumnImpl>{

    public LinkColumnBuilder() {
        super(ListViewLinkColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewLinkColumnImpl col, Element node) {

    }
}
