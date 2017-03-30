package org.platypus.builder.plugin.internal.field;

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
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

import javax.lang.model.element.Modifier;

import java.util.Optional;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BasicFieldConstructorGenerator {
    public Optional<MethodSpec> generateGetter(MetaInfoBigStringField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoBinaryField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoBooleanField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDateField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDateTimeField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoDecimalField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoFloatField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoIntField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoLongField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoStringField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    public Optional<MethodSpec> generateGetter(MetaInfoTimeField field){
        return getGetter(field.getName(), Utils.getJavaType(field));
    }
    private Optional<MethodSpec> getGetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder("get" + name)
                .addModifiers(Modifier.PUBLIC)
                .returns(field)
                .addCode("return this.$N;", name)
                .build());
    }


}
