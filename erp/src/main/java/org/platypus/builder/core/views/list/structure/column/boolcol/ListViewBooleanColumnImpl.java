package org.platypus.builder.core.views.list.structure.column.boolcol;

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
public class ListViewBooleanColumnImpl extends AbstractColumn implements ListViewBooleanColumn {
    private boolean toggleDisplayed;

    public ListViewBooleanColumnImpl() {
        super(ListViewColumn.ColumnType.BOOLEAN);
    }

    @Override
    public boolean isToggleDisplayed() {
        return toggleDisplayed;
    }

    public void setToggleDisplayed(boolean toggleDisplayed) {
        this.toggleDisplayed = toggleDisplayed;
    }

    @Override
    public ListViewColumn.ColumnType getColumnType() {
        return ListViewColumn.ColumnType.BOOLEAN;
    }

    @Override
    public ContainerTag toContainerTag() {
        ContainerTag tag;
        if (toggleDisplayed){
            tag = TagCreator.tag("paper-toggle-button")
                    .attr("disable", "true")
                    .attr("checked", "[[item."+this.getPropertyName()+"]]");

        } else {
            tag = TagCreator.tag("paper-checkbox")
                    .attr("disable", "true")
                    .attr("checked", "[[item."+this.getPropertyName()+"]]");
        }
        return tag;
    }
}
