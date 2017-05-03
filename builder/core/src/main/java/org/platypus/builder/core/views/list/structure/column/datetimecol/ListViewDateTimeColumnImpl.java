package org.platypus.builder.core.views.list.structure.column.datetimecol;

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
public class ListViewDateTimeColumnImpl extends AbstractColumn implements ListViewDateTimeColumn {

    public ListViewDateTimeColumnImpl() {
        super(ColumnType.DATE_TIME);
    }

    private DisplayType displayType;

    @Override
    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    @Override
    public ContainerTag toContainerTag() {
        return TagCreator.tag("toto-date-time")
                .attr("date", "[[item."+propertyName+"]]")
                .attr("display", displayType.getValue());
    }
}
