package org.platypus.builder.core.internal.literral;


import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.LongFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
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
    protected boolean newField;

    @Override
    public boolean isNewField() {
        return newField;
    }

    @Override
    public void setNewField(boolean newField) {
        this.newField = newField;
    }
    protected LongFieldLitteral(String name) {
        this.name = name;
    }
    public LongFieldLitteral(String name, LongFieldDefinition annotation) {
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

    public static LongFieldLitteral idField() {
        LongFieldLitteral idField = new LongFieldLitteral("id");
        idField.readonly = Bool.TRUE;
        return idField;
    }
    //</editor-fold>
}
