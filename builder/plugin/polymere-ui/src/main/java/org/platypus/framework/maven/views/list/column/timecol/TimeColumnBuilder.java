package org.platypus.framework.maven.views.list.column.timecol;

import org.platypus.framework.maven.views.list.column.ColumnBuilder;
import org.w3c.dom.Element;

import static java.lang.Boolean.parseBoolean;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TimeColumnBuilder extends ColumnBuilder<ListViewTimeColumnImpl> {

    public TimeColumnBuilder() {
        super(ListViewTimeColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewTimeColumnImpl col, Element node) {
            col.setSecondDisplayed(parseBoolean(node.getAttribute("second")));
    }
}
