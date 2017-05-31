package org.platypus.impl.module.literral;


import org.platypus.api.annotations.field.BigStringFieldDefinition;
import org.platypus.api.fields.Bool;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BigStringFieldLiteral implements BasicFieldDef, MetaInfoBigStringField {
    
    private final String name;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
    protected Bool lazy = Bool.DEFAULT;
    protected Bool required = Bool.DEFAULT;
    protected Bool readonly = Bool.DEFAULT;
    protected String columnDoc = "";
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;

    public BigStringFieldLiteral(String name) {
        this.name = name;
    }

    //<editor-fold desc="Annotation method">
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Bool insertable() {
        return insertable;
    }

    @Override
    public Bool updatable() {
        return updatable;
    }

    @Override
    public String columnDoc() {
        return columnDoc;
    }

    @Override
    public boolean eraseWithYours() {
        return eraseWithYours;
    }

    @Override
    public Bool readonly() {
        return readonly;
    }

    @Override
    public Bool required() {
        return required;
    }

    @Override
    public String[] path() {
        return pathRelated;
    }

    @Override
    public Bool store() {
        return store;
    }

    @Override
    public Bool lazy() {
        return lazy;
    }

    @Override
    public Class<BigStringFieldDefinition> annotationType() {
        return BigStringFieldDefinition.class;
    }
    //</editor-fold>
}
