package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.*;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.BaseModel;
import org.platypus.api.fields.metainfo.*;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.builder.plugin.internal.Utils;
import org.platypus.builder.utils.javapoet.utils.FieldSpecUtils;

import java.beans.Transient;
import java.util.function.Function;

import static org.platypus.builder.plugin.internal.JpaModelGenerator.getImplHibernateName;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordGenerator {
    public FieldSpec generateField(MetaInfoBigStringField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoBinaryField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoBooleanField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDateField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDateTimeField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDecimalField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoFloatField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoIntField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoLongField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoStringField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoTimeField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
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
        return getField( name, ClassName.get(record.getPkg(), record.getClassName()));
    }
    private FieldSpec getField(String name, TypeName field){
        return FieldSpecUtils.privateFinalFieldBuilder(field, name+"Field")
                .addAnnotation(AnnotationSpec.builder(javax.persistence.Transient.class).build()).build();
    }
}
