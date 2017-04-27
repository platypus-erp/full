package org.platypus.builder.plugin.internal;


import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.plugin.internal.recordImpl.RecordImplFieldGenerator;
import org.platypus.builder.utils.javapoet.utils.ClassSpecUtils;
import org.platypus.builder.utils.javapoet.utils.Constant;

import javax.lang.model.element.Modifier;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
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

        MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
        TypeVariableName TvarRecord = TypeVariableName.get("T", ClassName.get(Record.class));
//        RecordImpl<T extends Record, R extends Record, RI extends R>

        JpaImplFieldGenerator fieldGenerator = new JpaImplFieldGenerator(jpaImplBuilder, modelMerged.getName(), constructor);
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

        jpaImplBuilder.addMethod(constructor.build());
        jpaImplBuiler.put(modelMerged.getName(), new HashSet<>());
        jpaImplBuiler.get(modelMerged.getName()).add(jpaImplBuilder);
        jpaImplBuiler.get(modelMerged.getName()).add(generateRecordImpl(modelMerged, getRecord, getRecordCollection));
        jpaImplBuiler.get(modelMerged.getName()).add(generateRecordCollectionImpl(modelMerged, getRecord, getRecordCollection));
    }

    public TypeSpec.Builder generateRecordCollectionImpl(ModelMerged modelMerged,
                                               Function<String, MetaInfoRecord> getRecord,
                                               Function<String, MetaInfoRecordCollection> getRecordCollection) {
        MetaInfoRecord rTarget = getRecord.apply(modelMerged.getName());
        ClassName recordTarget = ClassName.get(rTarget.getPkg(), rTarget.getClassName());

        MetaInfoRecordCollection rcTarget = getRecordCollection.apply(modelMerged.getName());
        ClassName recordCollectionTarget = ClassName.get(rcTarget.getPkg(), rcTarget.getClassName());

        ClassName recordTargetImpl = ClassName.get("", getImplHibernateName(modelMerged.getName()));
        ClassName currentClassName = ClassName.get("org.platypus.generated.jpa", rTarget.getClassName() + "CollectionImpl");

        TypeSpec.Builder recordCollectionImpl = TypeSpec.classBuilder(currentClassName)
                .addModifiers(Modifier.PUBLIC);

        TypeVariableName Tvar = TypeVariableName.get("T", ClassName.get(Record.class));

        recordCollectionImpl.addTypeVariable(Tvar);
        ParameterizedTypeName superClass = ParameterizedTypeName.get(ClassName.get(RecordCollectionImpl.class), Tvar, recordTarget, recordTargetImpl, recordCollectionTarget);

        recordCollectionImpl.superclass(superClass);
        recordCollectionImpl.addSuperinterface(recordCollectionTarget);

        ParameterizedTypeName listOfRecord = ParameterizedTypeName.get(ClassName.get(List.class), recordTargetImpl);
        ParameterizedTypeName classRecord = ParameterizedTypeName.get(ClassName.get(Class.class), recordTargetImpl);
        ParameterizedTypeName functionGetter = ParameterizedTypeName.get(ClassName.get(Function.class), Tvar, listOfRecord);
        ParameterizedTypeName functionSetter = ParameterizedTypeName.get(ClassName.get(BiConsumer.class), Tvar, listOfRecord);


        MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
        constructor.addModifiers(Modifier.PUBLIC);
        constructor.addParameter(ParameterSpec.builder(Tvar, "instance").build());
        constructor.addParameter(ParameterSpec.builder(classRecord, "recordTarget").build());
        constructor.addParameter(ParameterSpec.builder(functionGetter, "getter").build());
        constructor.addParameter(ParameterSpec.builder(functionSetter, "setter").build());

        constructor.addCode("super($N, $N, $N, $N);", "instance", "recordTarget", "getter", "setter");

        recordCollectionImpl.addMethod(constructor.build());
        return recordCollectionImpl;

    }

    public TypeSpec.Builder generateRecordImpl(ModelMerged modelMerged,
                                   Function<String, MetaInfoRecord> getRecord,
                                   Function<String, MetaInfoRecordCollection> getRecordCollection) {
        MetaInfoRecord rTarget = getRecord.apply(modelMerged.getName());
        ClassName recordTarget = ClassName.get(rTarget.getPkg(), rTarget.getClassName());

        ClassName recordTargetImpl = ClassName.get("", getImplHibernateName(modelMerged.getName()));
        ClassName currentClassName = ClassName.get("fakePkg", rTarget.getClassName() + "Impl");

        TypeSpec.Builder recordImpl = TypeSpec.classBuilder(currentClassName)
                .addModifiers(Modifier.PUBLIC);

        ParameterizedTypeName superClass = ParameterizedTypeName.get(recordTarget, recordTargetImpl);

        recordImpl.superclass(superClass);
        recordImpl.addSuperinterface(recordTarget);

        ParameterizedTypeName functionGetter = ParameterizedTypeName.get(ClassName.get(Supplier.class), recordTargetImpl);
        ParameterizedTypeName functionSetter = ParameterizedTypeName.get(ClassName.get(Consumer.class), recordTargetImpl);


        MethodSpec.Builder constructor = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
        constructor.addModifiers(Modifier.PUBLIC);
        constructor.addParameter(ParameterSpec.builder(functionGetter, "getter").build());
        constructor.addParameter(ParameterSpec.builder(functionSetter, "setter").build());

        constructor.addCode("super($N, $N);", "getter", "setter");

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


//
//            for (RelationFieldLiteral f : fr.getAllRelationFieldDef()) {
//                if (f.getRealType() == PlatypusType.OTM || f.getRealType() == PlatypusType.MTM) {
//                    MethodSpec getter = MethodSpec.methodBuilder(f.getName())
//                            .returns(allRecordCollections.get(f.getTargettFqn()))
//                            .addCode("return get().$N();", f.getName())
//                            .addAnnotation(Override.class)
//                            .addModifiers(Modifier.PUBLIC)
//                            .build();
//                    recordImpl.addMethod(getter);
//
//                    MethodSpec setter = MethodSpec.methodBuilder(f.getName())
//                            .addParameter(ParameterSpec.builder(allRecordCollections.get(f.getTargettFqn()), f.getName(), Modifier.FINAL).build())
//                            .addCode("this.get().$N($N);", f.getName(), f.getName())
//                            .addAnnotation(Override.class)
//                            .addModifiers(Modifier.PUBLIC)
//                            .build();
//                    recordImpl.addMethod(setter);
//                } else {
//                    MethodSpec getter = MethodSpec.methodBuilder(f.getName())
//                            .returns(allRecords.get(f.getTargettFqn()))
//                            .addCode("return get().$N();", f.getName())
//                            .addAnnotation(Override.class)
//                            .addModifiers(Modifier.PUBLIC)
//                            .build();
//                    recordImpl.addMethod(getter);
//
//                    MethodSpec setter = MethodSpec.methodBuilder(f.getName())
//                            .addParameter(ParameterSpec.builder(allRecords.get(f.getTargettFqn()), f.getName(), Modifier.FINAL).build())
//                            .addCode("this.get().$N($N);", f.getName(), f.getName())
//                            .addAnnotation(Override.class)
//                            .addModifiers(Modifier.PUBLIC)
//                            .build();
//                    recordImpl.addMethod(setter);
//                }
//            }
        return recordImpl;
    }

    private <K, V> void foreachValues(Map<K, V> map, Consumer<V> consumer) {
        map.values().forEach(consumer);
    }


}
