package org.platypus.builder.plugin.internal.recordImpl;

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

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class RecordImplFieldGenerator {
    BasicFieldRecordImplGetterGenerator basicFieldRecordImplGetterGenerator = new BasicFieldRecordImplGetterGenerator();
    BasicFieldRecordImplSetterGenerator basicFieldRecordImplSetterGenerator = new BasicFieldRecordImplSetterGenerator();

    TypeSpec.Builder recordImplBuilder;

    public RecordImplFieldGenerator(TypeSpec.Builder recordImplBuilder) {
        this.recordImplBuilder = recordImplBuilder;
    }

    public void generateField(MetaInfoBigStringField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoBinaryField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoBooleanField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoDateField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoDateTimeField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoDecimalField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoFloatField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoIntField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoLongField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoStringField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }
    public void generateField(MetaInfoTimeField meta){
        basicFieldRecordImplGetterGenerator.generateGetter(meta).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta).ifPresent(recordImplBuilder::addMethod);
    }

    public void generateField(MetaInfoManyToOneField meta, Function<String, MetaInfoRecord> getRecord){
        basicFieldRecordImplGetterGenerator.generateGetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
    }

    public void generateField(MetaInfoOneToOneField meta, Function<String, MetaInfoRecord> getRecord){
        basicFieldRecordImplGetterGenerator.generateGetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
    }

    public void generateField(MetaInfoOneToManyField meta, Function<String, MetaInfoRecordCollection> getRecord){
        basicFieldRecordImplGetterGenerator.generateGetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
    }

    public void generateField(MetaInfoManyToManyField meta, Function<String, MetaInfoRecordCollection> getRecord){
        basicFieldRecordImplGetterGenerator.generateGetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
        basicFieldRecordImplSetterGenerator.generateSetter(meta, getRecord).ifPresent(recordImplBuilder::addMethod);
    }
}
