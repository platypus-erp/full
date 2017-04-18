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
public class FieldSpecUtils {

    public static FieldSpec privateField(TypeName fieldType, String fieldName) {
        return FieldSpec.builder(fieldType, fieldName, Modifier.PRIVATE).build();
    }

    public static FieldSpec privateField(Class<?> fieldType, String fieldName) {
        return FieldSpec.builder(fieldType, fieldName, Modifier.PRIVATE).build();
    }

    public static FieldSpec privateField(Class<?> fieldType, String fieldName, Object value) {
        return FieldSpec
                .builder(fieldType, fieldName, Modifier.PRIVATE)
                .initializer("$V", value)
                .build();
    }

    public static FieldSpec privateFinalField(TypeName fieldType, String fieldName) {
        return FieldSpec.builder(fieldType, fieldName, Modifier.PRIVATE, Modifier.FINAL).build();
    }

    public static FieldSpec privateFinalField(Class<?> fieldType, String fieldName) {
        return FieldSpec.builder(fieldType, fieldName, Modifier.PRIVATE, Modifier.FINAL).build();
    }

    public static FieldSpec privateFinalField(Class<?> fieldType, String fieldName, Object value) {
        return FieldSpec
                .builder(fieldType, fieldName, Modifier.PRIVATE, Modifier.FINAL)
                .initializer("$V", value)
                .build();
    }


}
