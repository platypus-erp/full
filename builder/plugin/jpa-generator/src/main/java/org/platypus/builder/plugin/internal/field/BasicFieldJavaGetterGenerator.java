package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.fields.metainfo.*;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.builder.plugin.internal.JpaUtils;
import org.platypus.builder.utils.javapoet.utils.JavaPoetTypeUtils;

import javax.lang.model.element.Modifier;

import java.util.Optional;
import java.util.function.Function;

import static org.platypus.builder.plugin.internal.JpaModelGenerator.getImplHibernateName;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BasicFieldJavaGetterGenerator {
    public Optional<MethodSpec> generateGetter(MetaInfoBigStringField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoBinaryField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoBooleanField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDateField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDateTimeField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDecimalField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoFloatField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoIntField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoLongField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoStringField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoTimeField field){
        return getGetter(field.getName(), JpaUtils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoManyToOneField field) {
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getGetter(field.getName(), JpaImplT);
    }
    public Optional<MethodSpec> generateGetter(MetaInfoOneToOneField field) {
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getGetter(field.getName(), JpaImplT);
    }
    public Optional<MethodSpec> generateGetter(MetaInfoOneToManyField field) {
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getGetter(field.getName(), JavaPoetTypeUtils.ListType(JpaImplT));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoManyToManyField field) {
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getGetter(field.getName(), JavaPoetTypeUtils.ListType(JpaImplT));
    }
    private Optional<MethodSpec> getGetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder("get" + StringUtils.capitalize(name))
                .addModifiers(Modifier.PUBLIC)
                .returns(field)
                .addCode("return this.$N;\n", name)
                .build());
    }




}
