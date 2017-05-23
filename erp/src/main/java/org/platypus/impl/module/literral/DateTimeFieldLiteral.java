package org.platypus.impl.module.literral;


import org.platypus.api.Bool;
import org.platypus.api.annotations.field.DateTimeFieldDefinition;
import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DateTimeFieldLiteral implements MetaInfoDateTimeField, BasicFieldDef {
    private final String name;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
    protected Bool required = Bool.DEFAULT;
    protected Bool readonly = Bool.DEFAULT;
    protected String columnDoc = "";
    protected Bool defaultNow = Bool.DEFAULT;
    protected String uniqueHint = "";
    protected DateTimeRelative relative = DateTimeRelative.NONE;
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;

    protected DateTimeFieldLiteral(String name) {
        this.name = name;
    }

    public void setInsertable(Bool insertable) {
        this.insertable = insertable;
    }

    public void setUpdatable(Bool updatable) {
        this.updatable = updatable;
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

    public void setDefaultNow(Bool defaultNow) {
        this.defaultNow = defaultNow;
    }

    public void setUniqueHint(String uniqueHint) {
        this.uniqueHint = uniqueHint;
    }

    public void setRelative(DateTimeRelative relative) {
        this.relative = relative;
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
    public String uniqueHint() {
        return uniqueHint;
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
    public Bool defaultNow() {
        return defaultNow;
    }

    @Override
    public DateTimeRelative relative() {
        return relative;
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
    public Class<DateTimeFieldDefinition> annotationType() {
        return DateTimeFieldDefinition.class;
    }
    //</editor-fold>
}
