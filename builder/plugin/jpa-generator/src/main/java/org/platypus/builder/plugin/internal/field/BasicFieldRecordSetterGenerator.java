package org.platypus.builder.plugin.internal.field;

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
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.builder.plugin.internal.Utils;

import javax.lang.model.element.Modifier;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordSetterGenerator {
    public Optional<MethodSpec> generateSetter(MetaInfoBigStringField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBinaryField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBooleanField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateTimeField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDecimalField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoFloatField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoIntField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoLongField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoStringField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoTimeField field){
        return getSetter(field.getName(), Utils.getRecordFieldInterface(field));
    }
    private Optional<MethodSpec> getSetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder(name)
                .addParameter(ParameterSpec.builder(field, name+"InheritField", Modifier.FINAL).build())
                .addCode("this.set$N($N.get());", StringUtils.capitalize(name), name+"InheritField")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
}
