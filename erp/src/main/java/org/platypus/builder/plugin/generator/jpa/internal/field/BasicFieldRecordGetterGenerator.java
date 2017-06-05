package org.platypus.builder.plugin.generator.jpa.internal.field;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
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
import org.platypus.builder.plugin.generator.jpa.internal.JpaUtils;

import javax.lang.model.element.Modifier;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordGetterGenerator {
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoBigStringField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoBinaryField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoBooleanField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoDateField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoDateTimeField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoDecimalField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoFloatField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoIntField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoLongField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoStringField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoTimeField field){
        return getGetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoManyToOneField field,
                                              Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecord(record));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoOneToOneField field,
                                              Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecord(record));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoOneToManyField field,
                                               Function<String, MetaInfoRecordCollection> getRecord) {
        MetaInfoRecordCollection record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecordCollection(record));
    }
    public Optional<MethodSpec.Builder> generateGetter(MetaInfoManyToManyField field,
                                               Function<String, MetaInfoRecordCollection> getRecord) {
        MetaInfoRecordCollection record = getRecord.apply(field.targetName());
        return getGetter(field.getName(), Utils.toRecordCollection(record));
    }
    private Optional<MethodSpec.Builder> getGetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder(name)
                .returns(field)
//                .addCode("return $N;\n", methodName+"Field")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC));
    }
}
