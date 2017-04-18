package org.platypus.builder.utils.javapoet.utils;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class Constructor {

    public static MethodSpec.Builder publicConstructor() {
        return MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
    }

    public static MethodSpec.Builder packageConstructor() {
        return MethodSpec.constructorBuilder();
    }

    public static MethodSpec.Builder privateConstructor() {
        return MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE);
    }

    public static MethodSpec.Builder protectedConstructor() {
        return MethodSpec.constructorBuilder().addModifiers(Modifier.PROTECTED);
    }
}
