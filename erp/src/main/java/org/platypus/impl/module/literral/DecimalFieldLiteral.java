package org.platypus.impl.module.literral;


import org.platypus.api.Bool;
import org.platypus.api.annotations.field.BooleanFieldDefinition;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DecimalFieldLiteral implements MetaInfoDecimalField, BasicFieldDef {
    private final String name;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
    protected String defaultValue = "";
    protected float min = Float.MIN_VALUE;
    protected float max = Float.MAX_VALUE;
    protected Bool required = Bool.DEFAULT;
    protected Bool readonly = Bool.DEFAULT;
    protected String columnDoc = "";
    protected String uniqueHint = "";
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;

    protected DecimalFieldLiteral(String name) {
        this.name = name;
    }

    public Bool getInsertable() {
        return insertable;
    }

    public void setInsertable(Bool insertable) {
        this.insertable = insertable;
    }

    public Bool getUpdatable() {
        return updatable;
    }

    public void setUpdatable(Bool updatable) {
        this.updatable = updatable;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public Bool getRequired() {
        return required;
    }

    public void setRequired(Bool required) {
        this.required = required;
    }

    public Bool getReadonly() {
        return readonly;
    }

    public void setReadonly(Bool readonly) {
        this.readonly = readonly;
    }

    public String getColumnDoc() {
        return columnDoc;
    }

    public void setColumnDoc(String columnDoc) {
        this.columnDoc = columnDoc;
    }

    public String getUniqueHint() {
        return uniqueHint;
    }

    public void setUniqueHint(String uniqueHint) {
        this.uniqueHint = uniqueHint;
    }

    public boolean isEraseWithYours() {
        return eraseWithYours;
    }

    public void setEraseWithYours(boolean eraseWithYours) {
        this.eraseWithYours = eraseWithYours;
    }

    public boolean isComputed() {
        return computed;
    }

    public void setComputed(boolean computed) {
        this.computed = computed;
    }

    public boolean isRelated() {
        return related;
    }

    public void setRelated(boolean related) {
        this.related = related;
    }

    public String[] getPathRelated() {
        return pathRelated;
    }

    public void setPathRelated(String[] pathRelated) {
        this.pathRelated = pathRelated;
    }

    public Bool getStore() {
        return store;
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
    public String defaultValue() {
        return defaultValue;
    }

    @Override
    public Bool required() {
        return required;
    }

    @Override
    public float min() {
        return min;
    }

    @Override
    public float max() {
        return max;
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
    public Class<BooleanFieldDefinition> annotationType() {
        return BooleanFieldDefinition.class;
    }
    //</editor-fold>
}
