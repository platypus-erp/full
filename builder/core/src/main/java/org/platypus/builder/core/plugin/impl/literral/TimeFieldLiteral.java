package org.platypus.builder.core.plugin.impl.literral;


import org.platypus.api.Bool;
import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.annotations.field.TimeFieldDefinition;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TimeFieldLiteral implements MetaInfoTimeField, BasicFieldDef {
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

    protected TimeFieldLiteral(String name) {
        this.name = name;
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
    public Class<TimeFieldDefinition> annotationType() {
        return TimeFieldDefinition.class;
    }
    //</editor-fold>
}
