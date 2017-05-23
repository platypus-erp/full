package org.platypus.plugin.generator.jpa.internal.field;

import com.squareup.javapoet.*;
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
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.Utils;
import org.platypus.plugin.generator.jpa.internal.JpaUtils;
import org.platypus.builder.utils.javapoet.utils.FieldSpecUtils;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordGenerator {
    public FieldSpec generateField(MetaInfoBigStringField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoBinaryField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoBooleanField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDateField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDateTimeField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDecimalField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoFloatField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoIntField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoLongField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoStringField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoTimeField field){
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoManyToOneField field,
                                   Function<String, MetaInfoRecord> getRecord) {
        return generateRecordField(field.getName(), getRecord.apply(field.targetName()));
    }
    public FieldSpec generateField(MetaInfoOneToOneField field,
                                   Function<String, MetaInfoRecord> getRecord) {
        return generateRecordField(field.getName(), getRecord.apply(field.targetName()));
    }
    private FieldSpec generateRecordField(String name, MetaInfoRecord record) {
        return getField( name, Utils.toRecord(record));
    }
    public FieldSpec generateField(MetaInfoManyToManyField field,
                                   Function<String, MetaInfoRecordCollection> getRecord) {
        return generateRecordCollectionField(field.getName(), getRecord.apply(field.targetName()));
    }
    public FieldSpec generateField(MetaInfoOneToManyField field,
                                   Function<String, MetaInfoRecordCollection> getRecord) {
        return generateRecordCollectionField(field.getName(), getRecord.apply(field.targetName()));
    }
    private FieldSpec generateRecordCollectionField(String name, MetaInfoRecordCollection record) {
        return getField( name, Utils.toRecordCollection(record));
    }
    private FieldSpec getField(String name, TypeName field){
        return FieldSpecUtils.privateFinalFieldBuilder(field, name+"Field")
                .addAnnotation(AnnotationSpec.builder(javax.persistence.Transient.class).build()).build();
    }
}
