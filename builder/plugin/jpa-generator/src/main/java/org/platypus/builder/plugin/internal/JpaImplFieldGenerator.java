package org.platypus.builder.plugin.internal;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.fields.metainfo.*;
import org.platypus.builder.plugin.internal.field.*;


import static org.platypus.builder.plugin.internal.JpaModelGenerator.getImplHibernateName;

/**
 * Created by apasquier on 21/04/17.
 */
public class JpaImplFieldGenerator {

    BasicFieldJpaGenerator basicFieldJpaGenerator = new BasicFieldJpaGenerator();
    BasicFieldJavaGetterGenerator basicFieldJavaGetterGenerator = new BasicFieldJavaGetterGenerator();
    BasicFieldJavaSetterGenerator basicFieldJavaSetterGenerator = new BasicFieldJavaSetterGenerator();
    BasicFieldRecordSetterGenerator basicFieldRecordSetterGenerator = new BasicFieldRecordSetterGenerator();
    BasicFieldRecordGetterGenerator basicFieldRecordGetterGenerator = new BasicFieldRecordGetterGenerator();
    BasicFieldRecordGenerator basicFieldRecordGenerator = new BasicFieldRecordGenerator();
    BasicFieldRecordConstructorGenerator basicFieldRecordConstructorGenerator;
    TypeSpec.Builder jpaImplBuilder;
    MethodSpec.Builder constructor;

    public JpaImplFieldGenerator(TypeSpec.Builder jpaImplBuilder, String currentModelClassName, MethodSpec.Builder constructor) {
        this.constructor = constructor;
        this.jpaImplBuilder = jpaImplBuilder;
        basicFieldRecordConstructorGenerator =
                new BasicFieldRecordConstructorGenerator(getImplHibernateName(currentModelClassName));
    }

    public void generateField(MetaInfoBigStringField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoBinaryField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoBooleanField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoDateField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoDateTimeField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoDecimalField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoFloatField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoIntField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoLongField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoStringField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
    public void generateField(MetaInfoTimeField meta){
        basicFieldJpaGenerator.generatedFieldImpl(meta).ifPresent(jpaImplBuilder::addField);
        basicFieldJavaGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordSetterGenerator.generateSetter(meta).ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta).ifPresent(jpaImplBuilder::addMethod);
        jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(meta));
        constructor.addCode(basicFieldRecordConstructorGenerator.generateField(meta));
    }
}
