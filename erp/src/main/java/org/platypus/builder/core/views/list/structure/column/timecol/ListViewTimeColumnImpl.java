package org.platypus.builder.core.views.list.structure.column.timecol;

import j2html.TagCreator;
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
public class ListViewTimeColumnImpl extends AbstractColumn implements ListViewTimeColumn{

    private boolean secondDisplayed;

    public ListViewTimeColumnImpl() {
        super(ColumnType.TIME);
    }

    @Override
    public ColumnType getColumnType() {
        return ListViewColumn.ColumnType.TIME;
    }

    @Override
    public boolean isSecondDisplayed() {
        return secondDisplayed;
    }

    public void setSecondDisplayed(boolean secondDisplayed) {
        this.secondDisplayed = secondDisplayed;
    }

    @Override
    public ContainerTag toContainerTag() {
        return TagCreator.tag("toto-time")
                .attr("time", "[[item."+propertyName+"]]")
                .attr("second", Boolean.toString(secondDisplayed));
    }
}
