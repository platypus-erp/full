package org.platypus.builder.core.internal.literral;

import org.platypus.api.BaseModel;
import org.platypus.api.Bool;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.ManyToManyFieldDefinition;
import org.platypus.api.annotations.field.OneToManyFieldDefinition;
import org.platypus.api.annotations.field.PlatypusCascadeType;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/04/17.
 */
public class ManyToManyFieldLiteral implements MetaInfoManyToManyField, BasicFieldDef {

    protected String name;
    protected Class<? extends BaseModel> targettFqn;
    protected Bool updatable = Bool.DEFAULT;
    protected Bool required = Bool.DEFAULT;
    protected String columnDoc = "";
    protected boolean eraseWithYours = false;
    protected boolean computed;
    protected boolean related;
    protected String[] pathRelated;
    protected Bool store = Bool.DEFAULT;
    protected PlatypusCascadeType[] cascade;
    protected Bool readonly = Bool.DEFAULT;
    protected String where;
    protected String sortAsc;
    protected String sortDesc;

    protected boolean newField;

    @Override
    public boolean isNewField() {
        return newField;
    }

    @Override
    public void setNewField(boolean newField) {
        this.newField = newField;
    }

    public ManyToManyFieldLiteral(String name) {
        this.name = name;
    }

    public ManyToManyFieldLiteral(String name, ManyToManyFieldDefinition def) {
        this(name);
        eraseWithYours = def.eraseWithYours();
        targettFqn = def.target();
        this.cascade = def.cascade();
        updatable = def.updatable();
        required = def.required();
        columnDoc = def.columnDoc();
        this.sortAsc = def.sortAsc();
        this.where = def.where();
        this.sortDesc = def.sortDesc();
        this.readonly = def.readonly();
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
    public String where() {
        return where;
    }

    @Override
    public String sortAsc() {
        return sortAsc;
    }

    @Override
    public String sortDesc() {
        return sortDesc;
    }

    @Override
    public Class<ManyToManyFieldDefinition> annotationType() {
        return ManyToManyFieldDefinition.class;
    }
}
