package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import org.platypus.api.fields.metainfo.*;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.builder.core.Utils;
import org.platypus.builder.plugin.internal.JpaUtils;

import javax.lang.model.element.Modifier;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordGetterGenerator {
    public Optional<MethodSpec> generateGetter(MetaInfoBigStringField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoBinaryField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoBooleanField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDateField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDateTimeField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDecimalField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoFloatField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoIntField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoLongField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoStringField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoTimeField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoManyToOneField field,
                                              Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecord(record));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoOneToOneField field,
                                              Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecord(record));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoOneToManyField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecordCollection(record));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoManyToManyField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecordCollection(record));
    }
    private Optional<MethodSpec> getGetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder(name)
                .returns(field)
                .addCode("return $N;\n", name+"Field")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
}
