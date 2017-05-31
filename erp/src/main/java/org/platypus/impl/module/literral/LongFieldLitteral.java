package org.platypus.impl.module.literral;


import org.platypus.api.annotations.field.LongFieldDefinition;
import org.platypus.api.fields.Bool;
import org.platypus.api.fields.metainfo.MetaInfoLongField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class LongFieldLitteral implements MetaInfoLongField, BasicFieldDef {

    private final String name;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
    protected long defaultValue = Long.MIN_VALUE;
    protected long min = Long.MIN_VALUE;
    protected long max = Long.MAX_VALUE;
    protected Bool required = Bool.DEFAULT;
    protected Bool readonly = Bool.DEFAULT;
    protected String columnDoc = "";
    protected String uniqueHint = "";
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;

    protected LongFieldLitteral(String name) {
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

    public long getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(long defaultValue) {
        this.defaultValue = defaultValue;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
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
    public long defaultValue() {
        return defaultValue;
    }

    @Override
    public Bool required() {
        return required;
    }

    @Override
    public long min() {
        return min;
    }

    @Override
    public long max() {
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
    public Class<LongFieldDefinition> annotationType() {
        return LongFieldDefinition.class;
    }
    //</editor-fold>
}
