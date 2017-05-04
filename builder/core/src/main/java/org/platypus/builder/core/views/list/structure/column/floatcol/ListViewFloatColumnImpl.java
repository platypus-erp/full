package org.platypus.builder.core.views.list.structure.column.floatcol;

import j2html.TagCreator;
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
public class ListViewFloatColumnImpl extends AbstractColumn implements ListViewFloatColumn {
    public ListViewFloatColumnImpl() {
        super(ColumnType.FLOAT);
    }

    @Override
    public ContainerTag toContainerTag() {
        return TagCreator.tag("toto-label")
                .attr("label", "[[item."+propertyName+"]]");
    }
}
