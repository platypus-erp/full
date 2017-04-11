package org.platypus.builder.plugin.internal;


import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.fields.BigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.plugin.internal.field.BasicFieldJavaGetterGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldJavaSetterGenerator;
import org.platypus.builder.plugin.internal.field.BasicFieldJpaGenerator;
import org.platypus.builder.utils.javapoet.ClassSpecUtils;
import org.platypus.builder.utils.javapoet.Constant;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    public void generate(ModelMerged modelMerged){
        TypeSpec.Builder jpaImplBuilder = ClassSpecUtils.publicClass(ClassName.get("org.platypus.generated.jpa", getImplHibernateName(modelMerged.getName())));
        String tableName = TO_SQL.apply(modelMerged.getName());

        jpaImplBuilder.addField(Constant.publicStaticFinalString("MODEL_NAME", tableName));

        jpaImplBuilder.addAnnotation(AnnotationSpec
                .builder(Table.class)
                .addMember("name", "$N", "MODEL_NAME")
                .build());

        jpaImplBuilder.addAnnotation(Entity.class);
        BasicFieldJpaGenerator basicFieldJpaGenerator = new BasicFieldJpaGenerator();
        BasicFieldJavaGetterGenerator basicFieldJavaGetterGenerator = new BasicFieldJavaGetterGenerator();
        BasicFieldJavaSetterGenerator basicFieldJavaSetterGenerator = new BasicFieldJavaSetterGenerator();
        for (Map.Entry<String, MetaInfoBigStringField> r : modelMerged.getBigStringField().entrySet()) {
            basicFieldJpaGenerator.generatedFieldImpl(r.getValue()).ifPresent(jpaImplBuilder::addField);
            basicFieldJavaGetterGenerator.generateGetter(r.getValue()).ifPresent(jpaImplBuilder::addMethod);
            basicFieldJavaSetterGenerator.generateSetter(r.getValue()).ifPresent(jpaImplBuilder::addMethod);
//            r.getPlatypusRecordGetter(r.getRecordFieldInterface())
//                    .ifPresent(jpaImplBuilder::addMethod);
//            r.getPlatypusRecordSetter(r.getRecordFieldInterface())
//                    .ifPresent(jpaImplBuilder::addMethod);
//
//            jpaImplBuilder.addField(privateFinalField(r.getRecordFieldInterface(), r.getRecordFieldName()));
//
//
//            constructor.addCode(r.getConstructorRecordFieldStatement(jpaImplClassName));

        }
        jpaImplBuiler.put(modelMerged.getName(), jpaImplBuilder);
    }
}
