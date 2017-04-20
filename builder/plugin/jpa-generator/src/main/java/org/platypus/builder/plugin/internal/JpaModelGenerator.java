package org.platypus.builder.plugin.internal;


import com.squareup.javapoet.*;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.Record;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.plugin.internal.field.*;
import org.platypus.builder.utils.javapoet.utils.ClassSpecUtils;
import org.platypus.builder.utils.javapoet.utils.Constant;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.platypus.builder.utils.Utils.TO_SQL;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class JpaModelGenerator {

    Map<String, TypeSpec.Builder> jpaImplBuiler = new HashMap<>();

    public Map<String, TypeSpec.Builder> getJpaImplBuiler() {
        return jpaImplBuiler;
    }

    static String getImplHibernateName(String name) {
        return Arrays
                .stream(name.split("\\."))
                .map(StringUtils::capitalize)
                .collect(Collectors.joining("", "Impl", "JPA"));
    }
    public void generate(ModelMerged modelMerged,
                         Function<String, MetaInfoRecord> getRecord,
                         Function<String, MetaInfoRecordCollection> getRecordCollection){

        TypeSpec.Builder jpaImplBuilder = ClassSpecUtils.publicClass(getImplHibernateName(modelMerged.getName()));
        String tableName = TO_SQL.apply(modelMerged.getName());

        jpaImplBuilder.addField(Constant.publicStaticFinalString("MODEL_NAME", tableName));

        jpaImplBuilder.addAnnotation(AnnotationSpec
                .builder(Table.class)
                .addMember("name", "$N.$N", jpaImplBuilder.build().name, "MODEL_NAME")
                .build());

        jpaImplBuilder.addAnnotation(Entity.class);
        MetaInfoRecord rec = getRecord.apply(modelMerged.getName());
        jpaImplBuilder.addSuperinterface(ClassName.get(rec.getPkg(), rec.getClassName()));

        BasicFieldJpaGenerator basicFieldJpaGenerator = new BasicFieldJpaGenerator();
        BasicFieldJavaGetterGenerator basicFieldJavaGetterGenerator = new BasicFieldJavaGetterGenerator();
        BasicFieldJavaSetterGenerator basicFieldJavaSetterGenerator = new BasicFieldJavaSetterGenerator();
        BasicFieldRecordSetterGenerator basicFieldRecordSetterGenerator = new BasicFieldRecordSetterGenerator();
        BasicFieldRecordGetterGenerator basicFieldRecordGetterGenerator = new BasicFieldRecordGetterGenerator();
        BasicFieldRecordGenerator basicFieldRecordGenerator = new BasicFieldRecordGenerator();
        BasicFieldRecordConstructorGenerator basicFieldRecordConstructorGenerator =
                new BasicFieldRecordConstructorGenerator(getImplHibernateName(modelMerged.getName()));

        MethodSpec.Builder constructor = MethodSpec.constructorBuilder();
        TypeVariableName TvarRecord = TypeVariableName.get("T", ClassName.get(Record.class));
//        RecordImpl<T extends Record, R extends Record, RI extends R>

        for (Map.Entry<String, MetaInfoStringField> r : modelMerged.getStringField().entrySet()) {
            basicFieldJpaGenerator.generatedFieldImpl(r.getValue()).ifPresent(jpaImplBuilder::addField);
            basicFieldJavaGetterGenerator.generateGetter(r.getValue()).ifPresent(jpaImplBuilder::addMethod);
            basicFieldJavaSetterGenerator.generateSetter(r.getValue()).ifPresent(jpaImplBuilder::addMethod);
            basicFieldRecordSetterGenerator.generateSetter(r.getValue()).ifPresent(jpaImplBuilder::addMethod);
            basicFieldRecordGetterGenerator.generateGetter(r.getValue()).ifPresent(jpaImplBuilder::addMethod);
            jpaImplBuilder.addField(basicFieldRecordGenerator.generateField(r.getValue()));
            constructor.addCode(basicFieldRecordConstructorGenerator.generateField(r.getValue()));

        }
        jpaImplBuilder.addMethod(constructor.build());
        jpaImplBuiler.put(modelMerged.getName(), jpaImplBuilder);
    }
}
