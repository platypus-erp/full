package org.platypus.builder.core.records.complete;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Bool;
import org.platypus.api.Namable;
import org.platypus.api.Record;
import org.platypus.api.RecordCollection;
import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.Targetable;
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.utils.javapoet.builder.InterfaceBuilder;

import java.lang.annotation.Annotation;
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
public class RecordGenerator {

    Set<TypeSpec.Builder> fileToGenerate = new HashSet<>();


    public void generate(ModelMerged merged, RecordRegistry recordRegistry) {
        InterfaceBuilder recordBuilder = InterfaceBuilder.publicInterface(
                Utils.toRecord(recordRegistry.getRecords().get(merged.getName()))
        );
        recordBuilder.addSuperInterfaces(Record.class);

        generateBasicFieldRecord(merged, recordBuilder);

        generateRelationFieldRecord(merged, recordBuilder, recordRegistry);

        InterfaceBuilder recordCollectionBuilder = InterfaceBuilder.publicInterface(
                Utils.toRecordCollection(recordRegistry.getRecordCollections().get(merged.getName())));
        recordCollectionBuilder.addSuperInterfaces(
                ParameterizedTypeName.get(
                        ClassName.get(RecordCollection.class),
                        Utils.toRecord(recordRegistry.getRecords().get(merged.getName())))
        );

        fileToGenerate.add(recordBuilder.toBuilder());
        fileToGenerate.add(recordCollectionBuilder.toBuilder());
    }

    private void generateRelationFieldRecord(
            ModelMerged merged, InterfaceBuilder recordBuilder, RecordRegistry recordRegistry
    ) {
        addRecordRelationMethod(merged.getMtmField().values(), recordBuilder,
                Utils::toRecordCollectionName,
                recordRegistry,
                b -> b.readonly() != Bool.TRUE);

        addRecordRelationMethod(merged.getMtoField().values(), recordBuilder,
                Utils::toRecordName,
                recordRegistry,
                b -> b.readonly() != Bool.TRUE);

        addRecordRelationMethod(merged.getOtmField().values(), recordBuilder,
                Utils::toRecordName,
                recordRegistry,
                b -> b.readonly() != Bool.TRUE);

        addRecordRelationMethod(merged.getOtoField().values(), recordBuilder,
                Utils::toRecordCollectionName,
                recordRegistry,
                b -> b.readonly() != Bool.TRUE);
    }

    private <T extends Namable & Targetable> void addRecordRelationMethod(
            Collection<T> fields,
            InterfaceBuilder recordBuilder,
            Function<String, String> nameTransformer,
            RecordRegistry recordRegistry,
            Predicate<T> addSetter
    ) {
        fields.forEach(b -> recordBuilder.addOnlyReturnMethod(
                b.getName(),
                toClassName(recordRegistry, b, nameTransformer))
        );

        fields.stream().filter(addSetter).
                forEach(b -> recordBuilder.add1ParamMethod(
                        b.getName(),
                        toClassName(recordRegistry, b, nameTransformer),
                        b.getName()));

    }

    private ClassName toClassName(RecordRegistry recordRegistry, Targetable targetable, Function<String, String> nameTransformer) {
        return ClassName.get(targetable.targetPkg() + ".generated.records",
                nameTransformer.apply(recordRegistry.getRecords().get(targetable.targetName()).getClassName()));
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
