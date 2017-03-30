package org.platypus.builder.core;

import org.platypus.api.fields.StringField;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.api.module.ModelOfModulInfo;
import org.platypus.api.module.TypeModel;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractPlatypusModel<T extends AbstractPlatypusModel<T>> implements ModelOfModulInfo {


    private final String name;
    private final TypeModel typeModel;
    Set<StringField> stringFieldDefinitions = new HashSet<>();

    public AbstractPlatypusModel(String name, TypeModel typeModel) {
        this.name = name;
        this.typeModel = typeModel;
    }

    @Override
    public TypeModel getType() {
        return typeModel;
    }

    protected final T addField(StringField stringFieldDef){
        stringFieldDefinitions.add(stringFieldDef);
        return (T)this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<MetaInfoStringField> stringField() {
        return null;
    }

    @Override
    public Set<MetaInfoLongField> longField() {
        return null;
    }

    @Override
    public Set<MetaInfoIntField> intField() {
        return null;
    }

    @Override
    public Set<MetaInfoFloatField> floatField() {
        return null;
    }

    @Override
    public Set<MetaInfoDecimalField> decimalField() {
        return null;
    }

    @Override
    public Set<MetaInfoBigStringField> bigStringField() {
        return null;
    }

    @Override
    public Set<MetaInfoBinaryField> binaryField() {
        return null;
    }

    @Override
    public Set<MetaInfoDateField> dateField() {
        return null;
    }

    @Override
    public Set<MetaInfoDateTimeField> dateTimeField() {
        return null;
    }

    @Override
    public Set<MetaInfoTimeField> timeField() {
        return null;
    }
}
