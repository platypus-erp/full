package org.platypus.impl.module.literral;


import org.platypus.api.annotations.field.BinaryFieldDefinition;
import org.platypus.api.fields.Bool;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BinaryFieldLiteral implements MetaInfoBinaryField, BasicFieldDef {

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

    protected BinaryFieldLiteral(String name) {
        this.name = name;
    }

    public void setInsertable(Bool insertable) {
        this.insertable = insertable;
    }

    public void setUpdatable(Bool updatable) {
        this.updatable = updatable;
    }

    public void setLazy(Bool lazy) {
        this.lazy = lazy;
    }

    public void setRequired(Bool required) {
        this.required = required;
    }

    public void setReadonly(Bool readonly) {
        this.readonly = readonly;
    }

    public void setColumnDoc(String columnDoc) {
        this.columnDoc = columnDoc;
    }

    public void setEraseWithYours(boolean eraseWithYours) {
        this.eraseWithYours = eraseWithYours;
    }

    public void setComputed(boolean computed) {
        this.computed = computed;
    }

    public void setRelated(boolean related) {
        this.related = related;
    }

    public void setPathRelated(String[] pathRelated) {
        this.pathRelated = pathRelated;
    }

    public void setStore(Bool store) {
        this.store = store;
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
    public Class<BinaryFieldDefinition> annotationType() {
        return BinaryFieldDefinition.class;
    }
    //</editor-fold>
}
