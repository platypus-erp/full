package org.platypus.framework.maven.views.list.column.relation;

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
public class RelationColumnBuilder extends ColumnBuilder<ListViewRelationColumnImpl>{

    public RelationColumnBuilder() {
        super(ListViewRelationColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewRelationColumnImpl col, Element node) {
        col.setSubProperty(node.getAttribute("sub-property"));
    }
}
