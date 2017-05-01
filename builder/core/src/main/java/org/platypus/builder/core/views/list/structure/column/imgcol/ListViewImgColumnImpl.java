package org.platypus.builder.core.views.list.structure.column.imgcol;

import org.platypus.builder.core.views.list.structure.column.AbstractColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewImgColumnImpl extends AbstractColumn implements ListViewImgColumn {

    private Mask mask;
    private Type type;

    public ListViewImgColumnImpl() {
        super(ColumnType.IMG);
    }

    @Override
    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    @Override
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
