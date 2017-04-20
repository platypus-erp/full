package org.platypus.builder.core.plugin.record;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Bool;
import org.platypus.api.Record;
import org.platypus.api.RecordCollection;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.utils.javapoet.builder.InterfaceBuilder;

import javax.lang.model.element.Modifier;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.platypus.builder.core.plugin.record.Utils.toClassName;
import static org.platypus.builder.core.plugin.record.Utils.toRecord;

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
        for (MetaInfoStringField b : merged.getStringField().values()) {
            recordBuilder.addOnlyReturnMethod(b.getName(), Utils.getRecordFieldImpl(b));
            if (b.readonly() != Bool.TRUE) {
                recordBuilder.add1ParamMethod(b.getName(), Utils.getRecordFieldImpl(b), b.getName());
            }
        }
        InterfaceBuilder recordCollectionBuilder = InterfaceBuilder.publicInterface(
                recordRegistry.getRecordCollections().get(merged.getName()).getClassName());
        recordCollectionBuilder.addSuperInterfaces(
                ParameterizedTypeName.get(
                        ClassName.get(RecordCollection.class),
                        toClassName(recordRegistry.getRecords().get(merged.getName())))
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
}
