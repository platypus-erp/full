package org.platypus.builder.core.internal.literral;


import org.platypus.api.Bool;
import org.platypus.api.annotations.field.BinaryFieldDefinition;
import org.platypus.api.annotations.field.BooleanFieldDefinition;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BooleanFieldLiteral implements MetaInfoBooleanField, BasicFieldDef {
    private final String name;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
    protected Bool defaultValue = Bool.DEFAULT;
    protected Bool readonly = Bool.DEFAULT;
    protected String columnDoc = "";
    protected String uniqueHint = "";
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;
    protected boolean newField;

    @Override
    public boolean isNewField() {
        return newField;
    }

    @Override
    public void setNewField(boolean newField) {
        this.newField = newField;
    }
    protected BooleanFieldLiteral(String name) {
        this.name = name;
    }

    public BooleanFieldLiteral(String name, BooleanFieldDefinition annotation) {
        this.name = name;
        insertable = annotation.insertable();
        updatable = annotation.updatable();
        defaultValue = annotation.defaultValue();
        columnDoc = annotation.columnDoc();
        uniqueHint = annotation.uniqueHint();
        readonly = annotation.readonly();
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
    public Bool defaultValue() {
        return defaultValue;
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
