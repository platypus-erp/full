package org.platypus.builder.core.views.list.structure.column.imgcol;

import org.platypus.builder.core.views.list.structure.column.ColumnBuilder;
import org.w3c.dom.Element;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ImgColumnBuilder extends ColumnBuilder<ListViewImgColumnImpl> {

    public ImgColumnBuilder() {
        super(ListViewImgColumnImpl.class);
    }

    @Override
    protected void buildColumn(ListViewImgColumnImpl col, Element node) {
        col.setMask(parseMask(node.getAttribute("mask")));
        col.setType(parseType(node.getAttribute("type")));
    }

    private ListViewImgColumn.Type parseType(String type) {
        return ListViewImgColumn.Type.fromValue(type);
    }

    private ListViewImgColumn.Mask parseMask(String mask) {
        if (mask != null) {
            return ListViewImgColumn.Mask.fromValue(mask);
        } else {
            return null;
        }
    }
}
