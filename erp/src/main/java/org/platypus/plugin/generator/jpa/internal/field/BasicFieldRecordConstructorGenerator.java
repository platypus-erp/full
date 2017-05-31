package org.platypus.plugin.generator.jpa.internal.field;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;
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
import org.platypus.builder.core.Utils;
import org.platypus.plugin.generator.jpa.internal.JpaUtils;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordConstructorGenerator {
    private final String currentClassName;

    public BasicFieldRecordConstructorGenerator(String currentClassName) {
        this.currentClassName = currentClassName;
    }

    public CodeBlock generateField(MetaInfoBigStringField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoBinaryField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoBooleanField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoDateField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }

    public CodeBlock generateField(MetaInfoDateTimeField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoDecimalField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoFloatField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoIntField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoLongField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoStringField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoTimeField field) {
        return getField(field.getName(), JpaUtils.getRecordFieldImpl(field));
    }

    private CodeBlock getField(String name, TypeName field) {
        return CodeBlock.of("return new $T(MODEL_NAME, $S, this::$N, this::newRecord$N, this::set$N);\n",
                field,
                name,
                "getPath",
                StringUtils.capitalize(name),
                StringUtils.capitalize(name)
        );
    }
    public CodeBlock generateField(MetaInfoManyToOneField field,
                                   Function<String, MetaInfoRecord> getRecord) {
        return generateRecordField(field.getName(), field.targetName(), getRecord);
    }
    public CodeBlock generateField(MetaInfoOneToOneField field,
                                   Function<String, MetaInfoRecord> getRecord) {
        return generateRecordField(field.getName(), field.targetName(), getRecord);
    }
    private CodeBlock generateRecordField(String name, String fieldTargetName, Function<String, MetaInfoRecord> getRecord) {
        return CodeBlock.of("return new $T(MODEL_NAME, $S, this::$N, this::newRecord$N, this::set$N);\n",
                Utils.toRecordImpl(getRecord.apply(fieldTargetName)),
                name,
                "getPath",
                StringUtils.capitalize(name),
                StringUtils.capitalize(name));
    }
    public CodeBlock generateField(MetaInfoOneToManyField field,
                                   Function<String, MetaInfoRecordCollection> getRecord) {
        return generateRecordCollectionField(field.getName(), field.targetName(), getRecord);
    }
    public CodeBlock generateField(MetaInfoManyToManyField field,
                                   Function<String, MetaInfoRecordCollection> getRecord) {
        return generateRecordCollectionField(field.getName(), field.targetName(), getRecord);
    }
    private CodeBlock generateRecordCollectionField(String name, String fieldTargetName,
                                                    Function<String, ? extends MetaInfoRecord> getRecord) {
        return CodeBlock.of("return new $T(MODEL_NAME, $S,this::$N, this::newRecord$N, this::set$N);\n",
                Utils.toRecordCollectionImpl(getRecord.apply(fieldTargetName)),
                name,
                "getPath",
                StringUtils.capitalize(name),
                StringUtils.capitalize(name));
    }
}
