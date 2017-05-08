package org.platypus.builder.plugin.internal;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.plugin.internal.field.BasicFieldJavaGetterGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldJavaSetterGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldJpaGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldRecordConstructorGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldRecordGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldRecordGetterGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldRecordSetterGenerator;

import java.util.function.Function;

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

    public void generateField(MetaInfoBigStringField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoBinaryField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoBooleanField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoDateField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoDateTimeField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoDecimalField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoFloatField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoIntField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoLongField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoStringField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoTimeField meta) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoManyToOneField meta, Function<String, MetaInfoRecord> getRecord) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta, getRecord)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta, getRecord)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta, getRecord)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoOneToOneField meta, Function<String, MetaInfoRecord> getRecord) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta, getRecord)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta, getRecord)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta, getRecord)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoOneToManyField meta, Function<String, MetaInfoRecordCollection> getRecord) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta, getRecord)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta, getRecord)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta, getRecord)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

    public void generateField(MetaInfoManyToManyField meta, Function<String, MetaInfoRecordCollection> getRecord) {
        basicFieldJpaGenerator.generatedFieldImpl(meta)
                .ifPresent(jpaImplBuilder::addField);

        basicFieldJavaGetterGenerator.generateGetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldJavaSetterGenerator.generateSetter(meta)
                .ifPresent(jpaImplBuilder::addMethod);

        basicFieldRecordSetterGenerator.generateSetter(meta, getRecord)
                .ifPresent(jpaImplBuilder::addMethod);
        basicFieldRecordGetterGenerator.generateGetter(meta, getRecord)
                .map(mb -> mb.addCode(basicFieldRecordConstructorGenerator.generateField(meta, getRecord)).build())
                .ifPresent(jpaImplBuilder::addMethod);
    }

}
