package org.platypus.builder.core.internal;

import org.platypus.api.TypeModel;
import org.platypus.api.annotations.model.PlatypusInherit;
import org.platypus.api.annotations.model.PlatypusInheritMulti;
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
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public class MetaInfoModelImpl implements MetaInfoModel {
    private final String className;
    private final String name;
    private final String[] inheritNames;
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

    public MetaInfoModelImpl(String className, PlatypusModel platypusModel) {
        this.className = className;
        this.name = platypusModel.value();
        this.inheritNames = new String[0];
        this.typeModel = TypeModel.ROOT;
    }
    public MetaInfoModelImpl(String className, PlatypusInherit platypusInherit) {
        this.className = className;
        this.name = platypusInherit.values().getAnnotation(PlatypusModel.class).value();
        this.inheritNames = new String[]{name};
        this.typeModel = TypeModel.INHERIT;
    }
    public MetaInfoModelImpl(String className, PlatypusInheritMulti platypusInheritMulti) {
        this.className = className;
        this.name = platypusInheritMulti.name();
        this.inheritNames = Arrays.stream(platypusInheritMulti.inherits()).
                map(c -> c.getAnnotation(PlatypusModel.class).value()).toArray(String[]::new);
        this.typeModel = TypeModel.INHERIT_MULTI;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getInheritNames() {
        return inheritNames;
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

    public void add(MetaInfoStringField field){
        stringField.add(field);
    }

    public void add(MetaInfoLongField field){
        longField.add(field);
    }

    public void add(MetaInfoIntField field){
        intField.add(field);
    }
    public void add(MetaInfoBooleanField field){
        booleanField.add(field);
    }

    public void add(MetaInfoFloatField field){
        floatField.add(field);
    }

    public void add(MetaInfoDecimalField field){
        decimalField.add(field);
    }

    public void add(MetaInfoBigStringField field){
        bigStringField.add(field);
    }

    public void add(MetaInfoBinaryField field){
        binaryField.add(field);
    }

    public void add(MetaInfoDateField field){
        dateField.add(field);
    }
    public void add(MetaInfoDateTimeField field){
        dateTimeField.add(field);
    }

    public void add(MetaInfoTimeField field){
        timeField.add(field);
    }
}
