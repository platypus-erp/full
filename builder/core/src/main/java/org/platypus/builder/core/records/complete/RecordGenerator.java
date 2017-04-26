package org.platypus.builder.core.records.complete;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Bool;
import org.platypus.api.Namable;
import org.platypus.api.Record;
import org.platypus.api.RecordCollection;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.utils.javapoet.builder.InterfaceBuilder;

import javax.lang.model.element.Modifier;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static com.squareup.javapoet.MethodSpec.methodBuilder;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public class RecordGenerator {

    Set<TypeSpec.Builder> fileToGenerate = new HashSet<>();


    public void generate(ModelMerged merged, RecordRegistry recordRegistry) {
        InterfaceBuilder recordBuilder = InterfaceBuilder.publicInterface(
                recordRegistry.getRecords().get(merged.getName()).getClassName());
        recordBuilder.addSuperInterfaces(Record.class);
        generateBasicFieldRecord(merged, recordBuilder);
        merged.getMtoField().values().forEach(s -> System.out.println("MTO " + s.getName()));
        System.out.println(recordRegistry.getRecords().keySet());
        for (MetaInfoManyToOneField b : merged.getMtoField().values()) {
            System.out.println(b.targetName());
            recordBuilder.addOnlyReturnMethod(b.getName(),
                    ClassName.get(b.targetPkg() +".generated.records",
                    recordRegistry.getRecords().get(b.targetName()).getClassName()));
            if (b.readonly() != Bool.TRUE) {
                recordBuilder.add1ParamMethod(b.getName(),
                        ClassName.get(b.targetPkg() +".generated.records",
                        recordRegistry.getRecords().get(b.targetName()).getClassName()), b.getName());
            }

        }

        InterfaceBuilder recordCollectionBuilder = InterfaceBuilder.publicInterface(
                recordRegistry.getRecordCollections().get(merged.getName()).getClassName());
        recordCollectionBuilder.addSuperInterfaces(
                ParameterizedTypeName.get(
                        ClassName.get(RecordCollection.class),
                        Utils.toClassName(recordRegistry.getRecords().get(merged.getName())))
        );
//        for (RelationFieldLiteral b : roots.getValue().getFieldsRepresentation().getAllRelationFieldDef()) {
//            if (b.getRealType() == PlatypusType.OTM || b.getRealType() == PlatypusType.MTM) {
//                builder.addMethod(
//                        methodBuilder(b.getName())
//                                .returns(
//                                        allRecordCollections.get(b.getTargettFqn())
//                                ).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
//                if (b.readonly() != Bool.TRUE) {
//                    builder.addMethod(
//                            methodBuilder(b.getName())
//                                    .addParameter(
//                                            builder(allRecordCollections.get(b.getTargettFqn()),
//                                                    b.getName()).build()
//                                    ).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
//                }
//            } else {
//                builder.addMethod(
//                        methodBuilder(b.getName())
//                                .returns(
//                                        allRecords.get(b.getTargettFqn())
//                                ).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
//                if (b.readonly() != Bool.TRUE) {
//                    builder.addMethod(
//                            methodBuilder(b.getName())
//                                    .addParameter(
//                                            builder(allRecords.get(b.getTargettFqn()),
//                                                    b.getName()).build()
//                                    ).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build());
//                }
//            }
//        }
        fileToGenerate.add(recordBuilder.toBuilder());
        fileToGenerate.add(recordCollectionBuilder.toBuilder());
    }

    private void generateBasicFieldRecord(ModelMerged merged, InterfaceBuilder recordBuilder) {
        addRecordMethod(merged.getBigStringField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getBinaryField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getBooleanField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getDateField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getDateTimeField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getDecimalField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getFloatField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getIntField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getLongField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getStringField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
        addRecordMethod(merged.getTimeField().values(), recordBuilder, b -> b.readonly() != Bool.TRUE);
    }

    private <T extends Namable & Annotation> void addRecordMethod(Collection<T> fields, InterfaceBuilder recordBuilder, Predicate<T> addSetter) {
        fields.forEach(b -> recordBuilder.addOnlyReturnMethod(
                b.getName(), Utils.getRecordFieldImpl(b)));
        fields.stream().filter(addSetter).
                forEach(b -> recordBuilder.add1ParamMethod(b.getName(), Utils.getRecordFieldImpl(b), b.getName()));
    }
}
