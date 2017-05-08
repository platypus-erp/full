package org.platypus.builder.core.internal.literral;

import org.platypus.api.BaseModel;
import org.platypus.api.Bool;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.field.PlatypusCascadeType;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/04/17.
 */
public class OneToOneFieldLiteral implements MetaInfoOneToOneField, BasicFieldDef {

    protected String name;
    protected Class<? extends BaseModel> targettFqn;
    protected Bool updatable = Bool.DEFAULT;
    protected Bool required = Bool.DEFAULT;
    protected String columnDoc = "";
    protected String mappedBy = "";
    protected String uniqueHint = "";
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;
    protected PlatypusCascadeType[] cascade;
    protected Bool readonly = Bool.DEFAULT;

    protected boolean newField;

    @Override
    public boolean isNewField() {
        return newField;
    }

    @Override
    public void setNewField(boolean newField) {
        this.newField = newField;
    }

    protected OneToOneFieldLiteral(String name) {
        this.name = name;
    }

    public OneToOneFieldLiteral(String name, OneToOneFieldDefinition def) {
        this(name);
        eraseWithYours = def.eraseWithYours();
        targettFqn = def.target();
        this.cascade = def.cascade();
        updatable = def.updatable();
        required = def.required();
        columnDoc = def.columnDoc();
        uniqueHint = def.uniqueHint();
        mappedBy = def.mappedBy();
        readonly = def.readonly();
    }

    @Override
    public void fillComputed(ComputedFieldDefinition computed) {
        this.computed = true;
        this.store = computed.store();
    }

    @Override
    public void fillRelated(RelatedFieldDefinition related) {
        this.related = true;
        this.store = related.store();
        this.pathRelated = related.path();
    }

    @Override
    public String getName() {
        return name;
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
    public String[] path() {
        return pathRelated;
    }

    @Override
    public Bool store() {
        return store;
    }

    @Override
    public String mappedBy() {
        return mappedBy;
    }

    @Override
    public Class<? extends BaseModel> target() {
        return targettFqn;
    }

    @Override
    public PlatypusCascadeType[] cascade() {
        return cascade;
    }

    @Override
    public Bool required() {
        return required;
    }

    @Override
    public Bool readonly() {
        return readonly;
    }

    @Override
    public Class<OneToOneFieldDefinition> annotationType() {
        return OneToOneFieldDefinition.class;
    }
}
