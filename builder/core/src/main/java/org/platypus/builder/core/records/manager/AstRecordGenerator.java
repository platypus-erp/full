package org.platypus.builder.core.records.manager;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Bool;
import org.platypus.api.Record;
import org.platypus.api.RecordCollection;
import org.platypus.api.annotations.record.RecordOf;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.Utils;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import org.platypus.builder.core.records.manager.astvisitor.FieldModel;
import org.platypus.builder.utils.javapoet.builder.InterfaceBuilder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public class AstRecordGenerator {

    Set<FileToGenerate> fileToGenerate = new HashSet<>();

    public static class FileToGenerate{
        final TypeSpec.Builder builder;
        final String pkg;

        public FileToGenerate(String pkg, TypeSpec.Builder builder) {
            this.builder = builder;
            this.pkg = pkg;
        }

        public JavaFile.Builder toJavaFile(){
            return JavaFile.builder(pkg, builder.build());
        }
    }


    public void generateRootRecord(AstModel merged, AstRecordRegistry recordRegistry) {
        MetaInfoRecord currentRec = recordRegistry.getMetaInfoTargetByClassName(merged);
        MetaInfoRecordCollection currentRC = recordRegistry.getMetaInfoCollectionTargetByClassName(merged);

        InterfaceBuilder recordBuilder = InterfaceBuilder.publicInterface(currentRec.getClassName());
        recordBuilder.addSuperInterfaces(Record.class);
        recordBuilder.addAnnotation(
                AnnotationSpec.builder(RecordOf.class)
                .addMember("modelPkg", "$S", merged.getPkg())
                .addMember("modelClassName", "$S", merged.getClassName())
                .addMember("modelName", "$L", merged.getModelName())
        );

        generateBasicFieldRecord(merged, recordBuilder);

        generateRelationFieldRecord(merged, recordBuilder, recordRegistry);

        fileToGenerate.add(new FileToGenerate(currentRec.getPkg(), recordBuilder.toBuilder()));

        if (merged.isRootModel()){
            InterfaceBuilder recordCollectionBuilder = InterfaceBuilder.publicInterface(currentRC.getClassName());
            recordCollectionBuilder.addSuperInterfaces(
                    ParameterizedTypeName.get(
                            ClassName.get(RecordCollection.class),
                            Utils.toRecord(currentRec))
            );
            recordCollectionBuilder.addAnnotation(
                    AnnotationSpec.builder(RecordOf.class)
                            .addMember("modelPkg", "$S", merged.getPkg())
                            .addMember("modelClassName", "$S", merged.getClassName())
                            .addMember("modelName", "$L", merged.getModelName())
            );
            fileToGenerate.add(new FileToGenerate(currentRC.getPkg(), recordCollectionBuilder.toBuilder()));
        }
    }

    private void generateRelationFieldRecord(
            AstModel merged, InterfaceBuilder recordBuilder, AstRecordRegistry recordRegistry
    ) {
        addRecordRelationMethod(merged.getMtmField(), recordBuilder,
                recordRegistry::getMetaInfoCollectionTargetByClassName,
                b -> b.getReadonly() != Bool.TRUE);

        addRecordRelationMethod(merged.getMtoField(), recordBuilder,
                recordRegistry::getMetaInfoTargetByClassName,
                b -> b.getReadonly() != Bool.TRUE);

        addRecordRelationMethod(merged.getOtmField(), recordBuilder,
                recordRegistry::getMetaInfoCollectionTargetByClassName,
                b -> b.getReadonly() != Bool.TRUE);

        addRecordRelationMethod(merged.getOtoField(), recordBuilder,
                recordRegistry::getMetaInfoTargetByClassName,
                b -> b.getReadonly() != Bool.TRUE);
    }

    private void addRecordRelationMethod(
            Collection<FieldModel> fields,
            InterfaceBuilder recordBuilder,
            Function<String, MetaInfoRecord> recordRegistry,
            Predicate<FieldModel> addSetter
    ) {
        fields.forEach(b -> recordBuilder.addOnlyReturnMethod(
                b.getName(),
                toClassName(recordRegistry, b))
        );

        fields.stream().filter(addSetter).
                forEach(b -> recordBuilder.add1ParamMethod(
                        b.getName(),
                        toClassName(recordRegistry, b),
                        b.getName()));

    }

    private ClassName toClassName(Function<String, MetaInfoRecord> recordRegistry, FieldModel targetable) {
        System.out.println(targetable.getClassNameTarget());
        MetaInfoRecord target = recordRegistry.apply(targetable.getClassNameTarget());
        return ClassName.get(target.getPkg(), target.getClassName());
    }

    private void generateBasicFieldRecord(AstModel merged, InterfaceBuilder recordBuilder) {
        addRecordMethod(merged.getBigStringField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getBinaryField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getBooleanField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getDateField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getDateTimeField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getDecimalField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getFloatField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getIntField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getLongField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getStringField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
        addRecordMethod(merged.getTimeField(), recordBuilder, b -> b.getReadonly() != Bool.TRUE);
    }

    private void addRecordMethod(
            Collection<FieldModel> fields, InterfaceBuilder recordBuilder, Predicate<FieldModel> addSetter) {
        fields.forEach(b -> recordBuilder.addOnlyReturnMethod(
                b.getName(), b.getAnnotatedWith()));
        fields.stream().filter(addSetter).
                forEach(b -> recordBuilder.add1ParamMethod(b.getName(), b.getAnnotatedWith(), b.getName()));
    }
}
