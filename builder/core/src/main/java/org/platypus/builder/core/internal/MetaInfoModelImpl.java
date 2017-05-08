package org.platypus.builder.core.internal;

import org.platypus.api.BaseModel;
import org.platypus.api.TypeModel;
import org.platypus.api.annotations.model.PlatypusModelInherit;
import org.platypus.api.annotations.model.PlatypusModel;
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
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public class MetaInfoModelImpl implements MetaInfoModel {
    private final Class<?> classModel;
    private final String name;
    private final String moduleName;
    private final String[] inheritNames;
    private final Class<? extends BaseModel>[] inherits;
    private final TypeModel typeModel;
    Set<MetaInfoStringField> stringField = new HashSet<>();
    Set<MetaInfoLongField> longField = new HashSet<>();
    Set<MetaInfoBooleanField> booleanField = new HashSet<>();
    Set<MetaInfoIntField> intField = new HashSet<>();
    Set<MetaInfoFloatField> floatField = new HashSet<>();
    Set<MetaInfoDecimalField> decimalField = new HashSet<>();
    Set<MetaInfoBigStringField> bigStringField = new HashSet<>();
    Set<MetaInfoBinaryField> binaryField = new HashSet<>();
    Set<MetaInfoDateField> dateField = new HashSet<>();
    Set<MetaInfoDateTimeField> dateTimeField = new HashSet<>();
    Set<MetaInfoTimeField> timeField = new HashSet<>();

    Set<MetaInfoOneToManyField> otmField = new HashSet<>();
    Set<MetaInfoOneToOneField> otoField = new HashSet<>();
    Set<MetaInfoManyToManyField> mtmField = new HashSet<>();
    Set<MetaInfoManyToOneField> mtoField = new HashSet<>();

    public MetaInfoModelImpl(String moduleName, Class<?> aclass, PlatypusModel platypusModel) {
        this.classModel = aclass;
        this.moduleName = moduleName;
        this.name = platypusModel.value();
        this.inheritNames = new String[0];
        this.inherits = new Class[0];
        this.typeModel = TypeModel.ROOT;
    }

    public MetaInfoModelImpl(String moduleName, Class<?> aclass, PlatypusModelInherit platypusInherit) {
        this.classModel = aclass;
        this.moduleName = moduleName;
        this.name = platypusInherit.value().getAnnotation(PlatypusModel.class).value();
        this.inheritNames = new String[]{name};
        this.inherits = new Class[]{platypusInherit.value()};
        this.typeModel = TypeModel.INHERIT;
    }

    @Override
    public String getPkg() {
        return classModel.getPackage().getName();
    }

    @Override
    public String getModuleName() {
        return null;
    }

    @Override
    public String getClassName() {
        return classModel.getSimpleName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getInheritNames() {
        return inheritNames;
    }

    public Class[] getInherits() {
        return inherits;
    }

    @Override
    public TypeModel getType() {
        return typeModel;
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
    public Set<MetaInfoIntField> intField() {
        return intField;
    }

    @Override
    public Set<MetaInfoBooleanField> booleanField() {
        return booleanField;
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
        return otmField;
    }

    @Override
    public Set<MetaInfoOneToOneField> otoField() {
        return otoField;
    }

    @Override
    public Set<MetaInfoManyToManyField> mtmField() {
        return mtmField;
    }

    @Override
    public Set<MetaInfoManyToOneField> mtoField() {
        return mtoField;
    }

    public void add(MetaInfoManyToOneField field) {
        mtoField.add(field);
    }

    public void add(MetaInfoStringField field) {
        stringField.add(field);
    }

    public void add(MetaInfoManyToManyField field) {
        mtmField.add(field);
    }

    public void add(MetaInfoOneToOneField field) {
        otoField.add(field);
    }

    public void add(MetaInfoLongField field) {
        longField.add(field);
    }

    public void add(MetaInfoOneToManyField field) {
        otmField.add(field);
    }

    public void add(MetaInfoIntField field) {
        intField.add(field);
    }

    public void add(MetaInfoBooleanField field) {
        booleanField.add(field);
    }

    public void add(MetaInfoFloatField field) {
        floatField.add(field);
    }

    public void add(MetaInfoDecimalField field) {
        decimalField.add(field);
    }

    public void add(MetaInfoBigStringField field) {
        bigStringField.add(field);
    }

    public void add(MetaInfoBinaryField field) {
        binaryField.add(field);
    }

    public void add(MetaInfoDateField field) {
        dateField.add(field);
    }

    public void add(MetaInfoDateTimeField field) {
        dateTimeField.add(field);
    }

    public void add(MetaInfoTimeField field) {
        timeField.add(field);
    }
}
