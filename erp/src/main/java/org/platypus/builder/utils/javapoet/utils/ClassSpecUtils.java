package org.platypus.builder.utils.javapoet.utils;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class
                                ClassSpecUtils {

    public static TypeSpec.Builder publicClass(String classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PUBLIC);
    }

    public static TypeSpec.Builder publicClass(ClassName classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PUBLIC);
    }

    public static TypeSpec.Builder publicAbstractClass(String classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
    }

    public static TypeSpec.Builder publicAbstractClass(ClassName classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
    }

    public static TypeSpec.Builder publicFinalClass(String classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PUBLIC, Modifier.FINAL);
    }

    public static TypeSpec.Builder publicFinalClass(ClassName classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PUBLIC, Modifier.FINAL);
    }

    public static TypeSpec.Builder privateAbstractClass(ClassName classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PRIVATE, Modifier.ABSTRACT);
    }

    public static TypeSpec.Builder privateAbstractClass(String classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PRIVATE, Modifier.ABSTRACT);
    }

    public static TypeSpec.Builder privateClass(ClassName classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PRIVATE);
    }

    public static TypeSpec.Builder privateClass(String classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PRIVATE);
    }

    public static TypeSpec.Builder privateFinalClass(ClassName classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PRIVATE, Modifier.FINAL);
    }

    public static TypeSpec.Builder privateFinalClass(String classname) {
        return TypeSpec.classBuilder(classname).addModifiers(Modifier.PRIVATE, Modifier.FINAL);
    }
}
