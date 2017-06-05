package org.platypus.impl.module.literral;


import org.platypus.api.annotations.field.RemoveSpaceType;
import org.platypus.api.annotations.field.RequiredType;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.fields.Bool;

import java.util.Arrays;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class StringFieldLiteral implements StringFieldSetter {
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

    protected StringFieldLiteral(String name) {
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


    public StringFieldLiteral setMatch(String match) {
        this.match = match;
        return this;
    }

    public StringFieldLiteral setRemoveSpace(RemoveSpaceType removeSpace) {
        this.removeSpace = removeSpace;
        return this;
    }

    public StringFieldLiteral setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    public StringFieldLiteral setMinSize(int minSize) {
        this.minSize = minSize;
        return this;
    }

    public StringFieldLiteral setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public StringFieldLiteral setRequired(RequiredType required) {
        this.required = required;
        return this;
    }

    public StringFieldLiteral setInsertable(Bool insertable) {
        this.insertable = insertable;
        return this;
    }

    public StringFieldLiteral setUpdatable(Bool updatable) {
        this.updatable = updatable;
        return this;
    }

    public StringFieldLiteral setReadonly(Bool readonly) {
        this.readonly = readonly;
        return this;
    }

    public StringFieldLiteral setColumnDoc(String columnDoc) {
        this.columnDoc = columnDoc;
        return this;
    }

    public StringFieldLiteral setUniqueHint(String uniqueHint) {
        this.uniqueHint = uniqueHint;
        return this;
    }

    public StringFieldLiteral setEraseWithYours(boolean eraseWithYours) {
        this.eraseWithYours = eraseWithYours;
        return this;
    }

    public StringFieldLiteral setComputed(boolean computed) {
        this.computed = computed;
        return this;
    }

    public StringFieldLiteral setRelated(boolean related) {
        this.related = related;
        return this;
    }

    public StringFieldLiteral setPathRelated(String[] pathRelated) {
        this.pathRelated = pathRelated;
        return this;
    }

    public StringFieldLiteral setStore(Bool store) {
        this.store = store;
        return this;
    }

    @Override
    public String toString() {
        return "StringFieldLiteral{" +
                "methodName='" + name + '\'' +
                ", match='" + match + '\'' +
                ", removeSpace=" + removeSpace +
                ", maxSize=" + maxSize +
                ", minSize=" + minSize +
                ", defaultValue='" + defaultValue + '\'' +
                ", required=" + required +
                ", insertable=" + insertable +
                ", updatable=" + updatable +
                ", readonly=" + readonly +
                ", columnDoc='" + columnDoc + '\'' +
                ", uniqueHint='" + uniqueHint + '\'' +
                ", eraseWithYours=" + eraseWithYours +
                ", computed=" + computed +
                ", related=" + related +
                ", pathRelated=" + Arrays.toString(pathRelated) +
                ", store=" + store +
                '}';
    }
}
