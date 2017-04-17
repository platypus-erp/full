package org.platypus.builder.core.internal.literral;

import org.platypus.api.Bool;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.FloatFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
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
    public FloatFieldLiteral(String name, FloatFieldDefinition annotation) {
        this.name = name;
        insertable = annotation.insertable();
        updatable = annotation.updatable();
        required = annotation.required();
        readonly = annotation.readonly();
        defaultValue = annotation.defaultValue();
        min = annotation.min();
        max = annotation.max();
        columnDoc = annotation.columnDoc();
        uniqueHint = annotation.uniqueHint();
        eraseWithYours = annotation.eraseWithYours();
    }

    @Override
    public void fillComputed(ComputedFieldDefinition annotation) {
        computed =true;
        related = false;
        pathRelated = new String[0];
        store = annotation.store();
    }

    @Override
    public void fillRelated(RelatedFieldDefinition annotation) {
        computed =false;
        related = true;
        pathRelated = annotation.path();
        store = annotation.store();
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
