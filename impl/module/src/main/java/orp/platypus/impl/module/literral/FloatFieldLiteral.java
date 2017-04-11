package orp.platypus.impl.module.literral;

import org.platypus.api.Bool;
import org.platypus.api.annotations.field.FloatFieldDefinition;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class FloatFieldLiteral implements MetaInfoFloatField, BasicFieldDef {
    private final String name;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
    protected float defaultValue = Float.MIN_VALUE;
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

    protected FloatFieldLiteral(String name) {
        this.name = name;
    }

    public void setInsertable(Bool insertable) {
        this.insertable = insertable;
    }

    public void setUpdatable(Bool updatable) {
        this.updatable = updatable;
    }

    public void setDefaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
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

    public void setUniqueHint(String uniqueHint) {
        this.uniqueHint = uniqueHint;
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
    public float defaultValue() {
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
    public Class<FloatFieldDefinition> annotationType() {
        return FloatFieldDefinition.class;
    }
    //</editor-fold>
}
