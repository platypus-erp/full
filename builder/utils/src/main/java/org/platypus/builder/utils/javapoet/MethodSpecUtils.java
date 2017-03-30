package org.platypus.builder.utils.javapoet;


/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class MethodSpecUtils {

//    public static MethodSpec emptySetter(String fieldName, TypeName fieldType) {
//        return emptySetter(() -> fieldName, fieldType);
//    }
//
//    public static MethodSpec emptySetter(JavaSetterMetodNamable setterMetodNamable, TypeName fieldType) {
//        return MethodSpec.methodBuilder(setterMetodNamable.getSetterJavaMethodName())
//                .addParameter(ParameterSpec.builder(fieldType, setterMetodNamable.getName()).build())
//                .build();
//    }
//
//    public static MethodSpec classicSetter(JavaSetterMetodNamable setterMetodNamable, TypeName fieldType) {
//        return MethodSpec.methodBuilder(setterMetodNamable.getSetterJavaMethodName())
//                .addParameter(ParameterSpec.builder(fieldType, setterMetodNamable.getName()).build())
//                .addCode("this.$N = $N;", setterMetodNamable.getName(), setterMetodNamable.getName())
//                .build();
//    }
//
//    public static MethodSpec classicSetterBuilder(JavaSetterMetodNamable setterMetodNamable, TypeName fieldType, TypeName returnType) {
//        return MethodSpec.methodBuilder(setterMetodNamable.getSetterJavaMethodName())
//                .addParameter(ParameterSpec.builder(fieldType, setterMetodNamable.getName()).build())
//                .addCode("this.$N = $N;", setterMetodNamable.getName(), setterMetodNamable.getName())
//                .returns(returnType)
//                .addCode("return this;")
//                .build();
//    }
//
//    public static MethodSpec nullGetter(String fieldName, TypeName returnType) {
//        return nullGetter(() -> fieldName, returnType);
//    }
//
//    public static MethodSpec nullGetter(JavaGetterMetodNamable getterMetodNamable, TypeName returnType) {
//        return MethodSpec.methodBuilder(getterMetodNamable.getGetterJavaMethodName())
//                .returns(returnType)
//                .addCode("return null;")
//                .build();
//    }
//
//    public static MethodSpec classicGetter(JavaGetterMetodNamable getterMetodNamable, TypeName returnType) {
//        return MethodSpec.methodBuilder(getterMetodNamable.getGetterJavaMethodName())
//                .returns(returnType)
//                .addCode("return this.$N;", getterMetodNamable.getName())
//                .build();
//    }
//
//    public static MethodSpec optionalNullableGetter(String fieldName, TypeName returnType) {
//        return optionalNullableGetter(() -> fieldName, returnType);
//    }
//
//    public static MethodSpec optionalNullableGetter(JavaGetterMetodNamable getterMetodNamable, TypeName returnType) {
//        return MethodSpec.methodBuilder(getterMetodNamable.getGetterJavaMethodName())
//                .returns(returnType)
//                .addCode("return Optionnal.ofNullable(this.$N);", getterMetodNamable.getName())
//                .build();
//    }


}
