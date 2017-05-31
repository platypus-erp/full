package org.platypus.builder.core.internal.literral;


import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
import org.platypus.api.annotations.field.RemoveSpaceType;
import org.platypus.api.annotations.field.RequiredType;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.fields.Bool;
import org.platypus.api.fields.metainfo.MetaInfoStringField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class StringFieldLiteral implements BasicFieldDef, MetaInfoStringField {
    private final String name;
    protected String match = "";
    protected RemoveSpaceType removeSpace = RemoveSpaceType.NONE;
    protected int maxSize = Integer.MAX_VALUE;
    protected int minSize = Integer.MIN_VALUE;
    protected String defaultValue = "";
    protected RequiredType required = RequiredType.NONE;
    protected Bool insertable = Bool.DEFAULT;
    protected Bool updatable = Bool.DEFAULT;
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
    protected StringFieldLiteral(String name) {
        this.name = name;
    }
    public StringFieldLiteral(String name, StringFieldDefinition annotation) {
        this.name = name;
        match = annotation.match();
        removeSpace = annotation.removeSpace();
        maxSize = annotation.maxSize();
        minSize = annotation.minSize();
        defaultValue = annotation.defaultValue();
        required = annotation.required();
        insertable = annotation.insertable();
        updatable = annotation.updatable();
        readonly = annotation.readonly();
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
    public String defaultValue() {
        return defaultValue;
    }

    @Override
    public RequiredType required() {
        return required;
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public int minSize() {
        return minSize;
    }

    @Override
    public RemoveSpaceType removeSpace() {
        return removeSpace;
    }

    @Override
    public String match() {
        return match;
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
    public Class<StringFieldDefinition> annotationType() {
        return StringFieldDefinition.class;
    }

    public boolean isComputed() {
        return computed;
    }

    public boolean isRelated() {
        return related;
    }

    //</editor-fold>
}
