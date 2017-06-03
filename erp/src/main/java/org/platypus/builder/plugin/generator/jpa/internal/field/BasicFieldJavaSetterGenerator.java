package org.platypus.builder.plugin.generator.jpa.internal.field;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;
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
import org.platypus.builder.utils.javapoet.utils.JavaPoetTypeUtils;
import org.platypus.builder.plugin.generator.jpa.internal.JpaModelGenerator;
import org.platypus.builder.plugin.generator.jpa.internal.JpaUtils;

import javax.lang.model.element.Modifier;

import java.util.Optional;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BasicFieldJavaSetterGenerator {
    public Optional<MethodSpec> generateSetter(MetaInfoBigStringField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBinaryField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBooleanField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateTimeField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDecimalField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoFloatField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoIntField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoLongField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoStringField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoTimeField field){
        return getSetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoManyToOneField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        return getSetter(field.getName(), JpaImplT);
    }
    public Optional<MethodSpec> generateSetter(MetaInfoOneToOneField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        return getSetter(field.getName(), JpaImplT);
    }
    public Optional<MethodSpec> generateSetter(MetaInfoOneToManyField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        return getSetter(field.getName(), JavaPoetTypeUtils.ListType(JpaImplT));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoManyToManyField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        return getSetter(field.getName(), JavaPoetTypeUtils.ListType(JpaImplT));
    }
    private Optional<MethodSpec> getSetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder("set" + StringUtils.capitalize(name))
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ParameterSpec.builder(field, name, Modifier.FINAL).build())
                .addCode("this.$N = $N;\n", name, name)
                .build());
    }


}
