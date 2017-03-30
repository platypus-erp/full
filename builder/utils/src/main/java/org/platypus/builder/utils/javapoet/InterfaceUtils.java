package org.platypus.builder.utils.javapoet;

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
public class InterfaceUtils {

    public static TypeSpec.Builder publicInterface(String classname) {
        return TypeSpec.interfaceBuilder(classname).addModifiers(Modifier.PUBLIC);
    }

    public static TypeSpec.Builder publicInterface(ClassName classname) {
        return TypeSpec.interfaceBuilder(classname).addModifiers(Modifier.PUBLIC);
    }

    public static TypeSpec.Builder privateInterface(String classname) {
        return TypeSpec.interfaceBuilder(classname).addModifiers(Modifier.PRIVATE);
    }

    public static TypeSpec.Builder privateInterface(ClassName classname) {
        return TypeSpec.interfaceBuilder(classname).addModifiers(Modifier.PRIVATE);
    }
}
