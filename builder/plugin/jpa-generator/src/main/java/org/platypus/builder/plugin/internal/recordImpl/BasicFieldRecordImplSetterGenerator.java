package org.platypus.builder.plugin.internal.recordImpl;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import org.platypus.api.fields.metainfo.*;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.builder.core.records.complete.Utils;
import org.platypus.builder.plugin.internal.JpaUtils;

import javax.lang.model.element.Modifier;

import java.util.Optional;
import java.util.function.Function;

import static org.platypus.builder.plugin.internal.JpaModelGenerator.getImplHibernateName;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordImplSetterGenerator {
    public Optional<MethodSpec> generateSetter(MetaInfoBigStringField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBinaryField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBooleanField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateTimeField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDecimalField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoFloatField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoIntField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoLongField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoStringField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoTimeField field){
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoManyToOneField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        return getSetter(field.getName(), Utils.toRecord(getRecord.apply(field.targetName())));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoOneToOneField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        return getSetter(field.getName(), Utils.toRecord(getRecord.apply(field.targetName())));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoOneToManyField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        return getSetter(field.getName(), Utils.toRecordCollection(getRecord.apply(field.targetName())));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoManyToManyField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        return getSetter(field.getName(), Utils.toRecordCollection(getRecord.apply(field.targetName())));
    }
    private Optional<MethodSpec> getSetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder(name)
                .addParameter(ParameterSpec.builder(field, name, Modifier.FINAL).build())
                .addCode("get().$N($N);\n", name, name)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
}
