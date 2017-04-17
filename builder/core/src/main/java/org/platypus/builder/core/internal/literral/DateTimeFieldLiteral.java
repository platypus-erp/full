package org.platypus.builder.core.internal.literral;


import org.platypus.api.Bool;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.DateTimeFieldDefinition;
import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
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
    public DateTimeFieldLiteral(String name, DateTimeFieldDefinition annotation) {
        this.name = name;
        insertable = annotation.insertable();
        updatable = annotation.updatable();
        required = annotation.required();
        readonly = annotation.readonly();
        defaultNow = annotation.defaultNow();
        columnDoc = annotation.columnDoc();
        uniqueHint = annotation.uniqueHint();
        relative = annotation.relative();
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
