package org.platypus.builder.utils.javapoet.builder;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

import java.util.Arrays;

import static com.squareup.javapoet.MethodSpec.methodBuilder;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public class InterfaceBuilder {
    private final TypeSpec.Builder internalBuilder;

    private InterfaceBuilder(TypeSpec.Builder internalBuilder) {
        this.internalBuilder = internalBuilder;
    }

    public static InterfaceBuilder publicInterface(String name) {
        return new InterfaceBuilder(TypeSpec.interfaceBuilder(name).addModifiers(Modifier.PUBLIC));
    }

    public static InterfaceBuilder publicInterface(ClassName name) {
        return new InterfaceBuilder(TypeSpec.interfaceBuilder(name).addModifiers(Modifier.PUBLIC));
    }

    public static InterfaceBuilder privateInterface(String name) {
        return new InterfaceBuilder(TypeSpec.interfaceBuilder(name).addModifiers(Modifier.PRIVATE));
    }

    public static InterfaceBuilder privateInterface(ClassName name) {
        return new InterfaceBuilder(TypeSpec.interfaceBuilder(name).addModifiers(Modifier.PRIVATE));
    }

    public static InterfaceBuilder protectedInterface(String name) {
        return new InterfaceBuilder(TypeSpec.interfaceBuilder(name).addModifiers(Modifier.PROTECTED));
    }

    public static InterfaceBuilder protectedInterface(ClassName name) {
        return new InterfaceBuilder(TypeSpec.interfaceBuilder(name).addModifiers(Modifier.PROTECTED));
    }

    public InterfaceBuilder addMethod(MethodSpec.Builder methodSpecBuilder) {
        this.internalBuilder.addMethod(methodSpecBuilder.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).build());
        return this;
    }

    public InterfaceBuilder add1ParamMethod(String methodName,
                                            TypeName typeparam1, String nameparam1, Modifier... modifierParam1) {
        this.internalBuilder.addMethod(
                MethodSpec.methodBuilder(methodName)
                        .addParameter(ParameterSpec.builder(typeparam1, nameparam1, modifierParam1).build())
                        .addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC)
                        .build()
        );
        return this;
    }

    public InterfaceBuilder addOnlyReturnMethod(String methodName, TypeName returnType) {
        System.out.println("add getMethod[" + methodName + "] retrun " + returnType);
        this.internalBuilder.addMethod(
                methodBuilder(methodName)
                        .returns(returnType)
                        .addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC)
                        .build()
        );
        return this;
    }

    public InterfaceBuilder addSuperInterfaces(Class<?>... superInterfaces) {
        Arrays.stream(superInterfaces)
                .map(ClassName::get)
                .forEach(this.internalBuilder::addSuperinterface);
        return this;
    }

    public InterfaceBuilder addSuperInterfaces(TypeName... superInterfaces) {
        Arrays.stream(superInterfaces)
                .forEach(this.internalBuilder::addSuperinterface);
        return this;
    }

    public TypeSpec.Builder toBuilder() {
        return internalBuilder;
    }

    public TypeSpec build() {
        return internalBuilder.build();
    }

    public void addAnnotation(AnnotationSpec.Builder builder) {
        internalBuilder.addAnnotation(builder.build());
    }
}
