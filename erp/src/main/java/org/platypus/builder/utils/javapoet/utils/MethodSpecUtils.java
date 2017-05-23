package org.platypus.builder.utils.javapoet.utils;


import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import org.platypus.builder.utils.Utils;

import javax.lang.model.element.Modifier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class MethodSpecUtils {

    public static MethodSpec classicOverrideSetter(String fieldName, TypeName fieldType) {
        return MethodSpec.methodBuilder("set" + Utils.capitalize(fieldName))
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(ParameterSpec.builder(fieldType, fieldName).build())
                .addCode("this.$N = $N;", fieldName, fieldName)
                .build();
    }

    public static MethodSpec classicOverrideGetter(String fieldName, TypeName returnType) {
        return MethodSpec.methodBuilder("get" + Utils.capitalize(fieldName))
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(returnType)
                .addCode("return this.$N;", fieldName)
                .build();
    }
    public static MethodSpec classicSetter(String fieldName, TypeName fieldType) {
        return MethodSpec.methodBuilder("set" + Utils.capitalize(fieldName))
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ParameterSpec.builder(fieldType, fieldName).build())
                .addCode("this.$N = $N;", fieldName, fieldName)
                .build();
    }

    public static MethodSpec classicGetter(String fieldName, TypeName returnType) {
        return MethodSpec.methodBuilder("get" + Utils.capitalize(fieldName))
                .addModifiers(Modifier.PUBLIC)
                .returns(returnType)
                .addCode("return this.$N;", fieldName)
                .build();
    }
}
