package org.platypus.builder.utils.javapoet.utils;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeName;

import javax.lang.model.element.Modifier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class Constant {

    public static FieldSpec publicStaticFinalString(String fieldName, String value) {
        return FieldSpec
                .builder(
                        JavaPoetTypeUtils.STRING_TYPE, fieldName,
                        Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL
                ).initializer("$S", value)
                .build();
    }

    public static FieldSpec publicStaticFinalInt(String fieldName, int value) {
        return FieldSpec
                .builder(
                        TypeName.INT, fieldName,
                        Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL
                ).initializer("$L", value)
                .build();
    }

    public static FieldSpec publicStaticFinalLong(String fieldName, long value) {
        return FieldSpec
                .builder(
                        TypeName.INT, fieldName,
                        Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL
                ).initializer("$L", value)
                .build();
    }

    public static FieldSpec publicStaticFinalFloat(String fieldName, float value) {
        return FieldSpec
                .builder(
                        TypeName.INT, fieldName,
                        Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL
                ).initializer("$L", value)
                .build();
    }

    public static FieldSpec publicStaticFinalBoolean(String fieldName, boolean value) {
        return FieldSpec
                .builder(
                        TypeName.INT, fieldName,
                        Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL
                ).initializer("$L", value)
                .build();
    }
}
