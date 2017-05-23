package org.platypus.builder.core.views.list.structure.column.linkcol;

import j2html.tags.ContainerTag;
import org.platypus.builder.core.views.list.structure.column.AbstractColumn;
import org.platypus.builder.core.views.list.structure.column.ListViewColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewLinkColumnImpl extends AbstractColumn implements ListViewLinkColumn {

    public ListViewLinkColumnImpl() {
        super(ListViewColumn.ColumnType.LINK);
    }

    @Override
    public ContainerTag toContainerTag() {
        return null;
    }
}
