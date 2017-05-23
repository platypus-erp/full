package org.platypus.plugin.generator.jpa.internal;


import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.query.QueryPath;
import org.platypus.builder.core.Utils;
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.plugin.generator.jpa.internal.recordImpl.RecordImplFieldGenerator;
import org.platypus.builder.utils.javapoet.utils.ClassSpecUtils;
import org.platypus.builder.utils.javapoet.utils.Constant;
import org.platypus.builder.utils.javapoet.utils.FieldSpecUtils;
import org.platypus.builder.utils.javapoet.utils.JavaPoetTypeUtils;
import org.platypus.builder.utils.javapoet.utils.MethodSpecUtils;

import javax.lang.model.element.Modifier;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class JpaModelGenerator {

    Map<String, Set<TypeSpec.Builder>> jpaImplBuiler = new HashMap<>();

    public Map<String, Set<TypeSpec.Builder>> getJpaImplBuiler() {
        return jpaImplBuiler;
    }

    public static String getImplHibernateName(String name) {
        return Arrays
                .stream(name.split("\\."))
                .map(StringUtils::capitalize)
                .collect(Collectors.joining("", "Impl", "JPA"));
    }

    public void generate(ModelMerged modelMerged,
                         Function<String, MetaInfoRecord> getRecord,
                         Function<String, MetaInfoRecordCollection> getRecordCollection) {
        jpaImplBuiler.put(modelMerged.getName(), new HashSet<>());
        jpaImplBuiler.get(modelMerged.getName()).add(generateImplJpa(modelMerged, getRecord, getRecordCollection));
        jpaImplBuiler.get(modelMerged.getName()).add(generateRecordImpl(modelMerged, getRecord, getRecordCollection));
        jpaImplBuiler.get(modelMerged.getName()).add(generateRecordCollectionImpl(modelMerged, getRecord, getRecordCollection));
    }

    private TypeSpec.Builder generateImplJpa(ModelMerged modelMerged,
                                             Function<String, MetaInfoRecord> getRecord,
                                             Function<String, MetaInfoRecordCollection> getRecordCollection) {

        String className = getImplHibernateName(modelMerged.getName());
        TypeSpec.Builder jpaImplBuilder = ClassSpecUtils.publicClass(className);
        String tableName = Utils.TO_SQL.apply(modelMerged.getName());

        jpaImplBuilder.addField(Constant.publicStaticFinalString("MODEL_NAME", tableName));

        jpaImplBuilder.addAnnotation(AnnotationSpec
                .builder(Table.class)
                .addMember("name", "$N.$N", className, "MODEL_NAME")
                .build());

        jpaImplBuilder.addAnnotation(Entity.class);
        MetaInfoRecord rec = getRecord.apply(modelMerged.getName());
        jpaImplBuilder.addSuperinterface(Utils.toRecord(rec));
        ClassName queryPathCls = ClassName.get(QueryPath.class);
        jpaImplBuilder.addField(
                FieldSpecUtils.privateFieldBuilder(QueryPath.class, "path")
                        .initializer("$T.basic(MODEL_NAME, $S)", queryPathCls, "id")
                        .build());

        jpaImplBuilder.addMethod(MethodSpecUtils.classicOverrideGetter("path", queryPathCls));
        jpaImplBuilder.addMethod(MethodSpecUtils.classicOverrideSetter("path", queryPathCls));

        MethodSpec.Builder resolvePath = MethodSpec.methodBuilder("resolve")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(queryPathCls)
                .addParameter(queryPathCls, "path")
                .addCode("return this.$N.resolve($N);\n", "path", "path");

        jpaImplBuilder.addMethod(resolvePath.build());

        JpaImplFieldGenerator fieldGenerator = new JpaImplFieldGenerator(jpaImplBuilder, modelMerged.getName());
        foreachValues(modelMerged.getBigStringField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getBinaryField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getBooleanField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getDateField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getDateTimeField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getDecimalField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getFloatField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getIntField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getLongField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getStringField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getTimeField(), fieldGenerator::generateField);

        foreachValues(modelMerged.getMtoField(), m -> fieldGenerator.generateField(m, getRecord));
        foreachValues(modelMerged.getOtoField(), m -> fieldGenerator.generateField(m, getRecord));
        foreachValues(modelMerged.getMtmField(), m -> fieldGenerator.generateField(m, getRecordCollection));
        foreachValues(modelMerged.getOtmField(), m -> fieldGenerator.generateField(m, getRecordCollection));

        return jpaImplBuilder;
    }

    public TypeSpec.Builder generateRecordCollectionImpl(ModelMerged modelMerged,
                                                         Function<String, MetaInfoRecord> getRecord,
                                                         Function<String, MetaInfoRecordCollection> getRecordCollection) {
        MetaInfoRecord rTarget = getRecord.apply(modelMerged.getName());
        ClassName recordTarget = Utils.toRecord(rTarget);

        ClassName recordCollectionTarget = Utils.toRecordCollection(getRecordCollection.apply(modelMerged.getName()));

        ClassName recordTargetImpl = ClassName.get("", getImplHibernateName(modelMerged.getName()));
        ClassName currentClassName = Utils.toRecordCollectionImpl(getRecordCollection.apply(modelMerged.getName()));

        TypeSpec.Builder recordCollectionImpl = TypeSpec.classBuilder(currentClassName)
                .addModifiers(Modifier.PUBLIC);


        ParameterizedTypeName superClass = ParameterizedTypeName.get(ClassName.get(RecordCollectionImpl.class), recordTarget, recordTargetImpl, recordCollectionTarget);

        recordCollectionImpl.superclass(superClass);
        recordCollectionImpl.addSuperinterface(recordCollectionTarget);

        ParameterizedTypeName listOfRecord = ParameterizedTypeName.get(ClassName.get(List.class), recordTargetImpl);
        ParameterizedTypeName functionGetter = ParameterizedTypeName.get(ClassName.get(Supplier.class), listOfRecord);
        ParameterizedTypeName getPath = ParameterizedTypeName.get(ClassName.get(Supplier.class), ClassName.get(QueryPath.class));
        ParameterizedTypeName functionSetter = ParameterizedTypeName.get(ClassName.get(Consumer.class), listOfRecord);


        MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
        constructor.addModifiers(Modifier.PUBLIC);
        constructor.addParameter(JavaPoetTypeUtils.STRING_TYPE, "table");
        constructor.addParameter(JavaPoetTypeUtils.STRING_TYPE, "name");
        constructor.addParameter(getPath, "getPath");
        constructor.addParameter(functionGetter, "getter");
        constructor.addParameter(functionSetter, "setter");

        constructor.addCode("super($N, $N, $N, $N, $N);\n",
                "table", "name", "getPath", "getter", "setter");

        recordCollectionImpl.addMethod(constructor.build());
        return recordCollectionImpl;

    }

    public TypeSpec.Builder generateRecordImpl(ModelMerged modelMerged,
                                               Function<String, MetaInfoRecord> getRecord,
                                               Function<String, MetaInfoRecordCollection> getRecordCollection) {
        MetaInfoRecord rTarget = getRecord.apply(modelMerged.getName());
        ClassName recordTarget = Utils.toRecord(rTarget);

        ClassName recordTargetImpl = ClassName.get("", getImplHibernateName(modelMerged.getName()));
        ClassName currentClassName = Utils.toRecordImpl(rTarget);

        TypeSpec.Builder recordImpl = TypeSpec.classBuilder(currentClassName)
                .addModifiers(Modifier.PUBLIC);

        ParameterizedTypeName superClass = ParameterizedTypeName.get(ClassName.get(RecordImpl.class), recordTarget, recordTargetImpl);

        recordImpl.superclass(superClass);
        recordImpl.addSuperinterface(recordTarget);

        ParameterizedTypeName functionGetter = ParameterizedTypeName.get(ClassName.get(Supplier.class), recordTargetImpl);
        ParameterizedTypeName functionSetter = ParameterizedTypeName.get(ClassName.get(Consumer.class), recordTargetImpl);
        ParameterizedTypeName getPath = ParameterizedTypeName.get(ClassName.get(Supplier.class), ClassName.get(QueryPath.class));

        MethodSpec.Builder constructor = MethodSpec.constructorBuilder();
        constructor.addModifiers(Modifier.PUBLIC);
        constructor.addParameter(JavaPoetTypeUtils.STRING_TYPE, "table");
        constructor.addParameter(JavaPoetTypeUtils.STRING_TYPE, "name");
        constructor.addParameter(getPath, "getPath");
        constructor.addParameter(functionGetter, "getter");
        constructor.addParameter(functionSetter, "setter");

        constructor.addCode("super($N, $N, $N, $N, $N, $T::new);\n", "table", "name", "getPath", "getter", "setter", recordTargetImpl);

        recordImpl.addMethod(constructor.build());

        RecordImplFieldGenerator fieldGenerator = new RecordImplFieldGenerator(recordImpl);
        foreachValues(modelMerged.getBigStringField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getBinaryField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getBooleanField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getDateField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getDateTimeField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getDecimalField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getFloatField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getIntField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getLongField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getStringField(), fieldGenerator::generateField);
        foreachValues(modelMerged.getTimeField(), fieldGenerator::generateField);

        foreachValues(modelMerged.getMtoField(), f -> fieldGenerator.generateField(f, getRecord));
        foreachValues(modelMerged.getOtoField(), f -> fieldGenerator.generateField(f, getRecord));
        foreachValues(modelMerged.getMtmField(), f -> fieldGenerator.generateField(f, getRecordCollection));
        foreachValues(modelMerged.getOtmField(), f -> fieldGenerator.generateField(f, getRecordCollection));
        return recordImpl;
    }

    private <K, V> void foreachValues(Map<K, V> map, Consumer<V> consumer) {
        map.values().forEach(consumer);
    }


}
