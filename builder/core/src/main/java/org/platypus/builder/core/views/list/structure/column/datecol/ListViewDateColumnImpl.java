package org.platypus.builder.core.views.list.structure.column.datecol;

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
public class ListViewDateColumnImpl extends AbstractColumn implements ListViewDateColumn {

    public ListViewDateColumnImpl() {
        super(ColumnType.DATE);
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
        return TagCreator.tag("toto-date")
                .attr("date", "[[item."+propertyName+"]]")
                .attr("mouthDisplay", displayType.getValue());
    }
}
