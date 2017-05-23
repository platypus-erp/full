package org.platypus.builder.core.views.list.structure.column.integercol;

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
public class ListViewIntegerColumnImpl extends AbstractColumn implements ListViewIntegerColumn {
    public ListViewIntegerColumnImpl() {
        super(ColumnType.INTEGER);
    }

    @Override
    public ContainerTag toContainerTag() {
        return null;
    }
}
