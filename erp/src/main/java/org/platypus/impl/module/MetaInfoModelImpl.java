package org.platypus.impl.module;

import org.platypus.api.TypeModel;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public final class MetaInfoModelImpl implements MetaInfoModel {



    private final String name;
    private final TypeModel typeModel;
    private final Set<MetaInfoStringField> stringField = new HashSet<>();
    private final Set<MetaInfoBooleanField> booleanField = new HashSet<>();
    private final Set<MetaInfoLongField> longField = new HashSet<>();
    private final Set<MetaInfoIntField> intField = new HashSet<>();
    private final Set<MetaInfoFloatField> floatField = new HashSet<>();
    private final Set<MetaInfoDecimalField> decimalField = new HashSet<>();
    private final Set<MetaInfoBigStringField> bigStringField = new HashSet<>();
    private final Set<MetaInfoBinaryField> binaryField = new HashSet<>();
    private final Set<MetaInfoDateField> dateField = new HashSet<>();
    private final Set<MetaInfoDateTimeField> dateTimeField = new HashSet<>();
    private final Set<MetaInfoTimeField> timeField = new HashSet<>();

    public MetaInfoModelImpl(String name, TypeModel typeModel) {
        this.name = name;
        this.typeModel = typeModel;
    }

    @Override
    public String getPkg() {
        return null;
    }

    @Override
    public String getModuleName() {
        return null;
    }

    @Override
    public TypeModel getType() {
        return typeModel;
    }

    protected final void addField(MetaInfoStringField stringFieldDef){
        stringField.add(stringFieldDef);
    }
    protected final void addField(MetaInfoBooleanField booleanFieldDef){
        booleanField.add(booleanFieldDef);
    }

    protected final void addField(MetaInfoLongField metaInfoLongField){
        longField.add(metaInfoLongField);
    }
    protected final void addField(MetaInfoIntField metaInfoIntField){
        intField.add(metaInfoIntField);
    }
    protected final void addField(MetaInfoFloatField metaInfoFloatField){
        floatField.add(metaInfoFloatField);
    }
    protected final void addField(MetaInfoDecimalField metaInfoDecimalField){
        decimalField.add(metaInfoDecimalField);
    }
    protected final void addField(MetaInfoBigStringField metaInfoBigStringField){
        bigStringField.add(metaInfoBigStringField);
    }
    protected final void addField(MetaInfoBinaryField metaInfoBinaryField){
        binaryField.add(metaInfoBinaryField);
    }
    protected final void addField(MetaInfoDateField metaInfoDateField){
        dateField.add(metaInfoDateField);
    }
    protected final void addField(MetaInfoDateTimeField metaInfoDateTimeField){
        dateTimeField.add(metaInfoDateTimeField);
    }
    protected final void addField(MetaInfoTimeField metaInfoTimeField){
        timeField.add(metaInfoTimeField);
    }

    @Override
    public String getClassName() {
        return null;
    }

    @Override
    public String[] getInheritNames() {
        return new String[0];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<MetaInfoStringField> stringField() {
        return stringField;
    }

    @Override
    public Set<MetaInfoLongField> longField() {
        return longField;
    }

    @Override
    public Set<MetaInfoBooleanField> booleanField() {
        return booleanField;
    }

    @Override
    public Set<MetaInfoIntField> intField() {
        return intField;
    }

    @Override
    public Set<MetaInfoFloatField> floatField() {
        return floatField;
    }

    @Override
    public Set<MetaInfoDecimalField> decimalField() {
        return decimalField;
    }

    @Override
    public Set<MetaInfoBigStringField> bigStringField() {
        return bigStringField;
    }

    @Override
    public Set<MetaInfoBinaryField> binaryField() {
        return binaryField;
    }

    @Override
    public Set<MetaInfoDateField> dateField() {
        return dateField;
    }

    @Override
    public Set<MetaInfoDateTimeField> dateTimeField() {
        return dateTimeField;
    }

    @Override
    public Set<MetaInfoTimeField> timeField() {
        return timeField;
    }

    @Override
    public Set<MetaInfoOneToManyField> otmField() {
        return null;
    }

    @Override
    public Set<MetaInfoOneToOneField> otoField() {
        return null;
    }

    @Override
    public Set<MetaInfoManyToManyField> mtmField() {
        return null;
    }

    @Override
    public Set<MetaInfoManyToOneField> mtoField() {
        return null;
    }
}
