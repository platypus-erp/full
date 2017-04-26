package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.ClassName;
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
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.plugin.internal.Utils;

import java.util.function.Function;

import static org.platypus.builder.plugin.internal.JpaModelGenerator.getImplHibernateName;

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
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoBinaryField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoBooleanField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoDateField field) {
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }

    public CodeBlock generateField(MetaInfoDateTimeField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoDecimalField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoFloatField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoIntField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoLongField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoStringField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    public CodeBlock generateField(MetaInfoTimeField field) {
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }

    private CodeBlock getField(String name, TypeName field) {
        return CodeBlock.of("$N = new $T<>(this, $N::get$N, $N::set$N);\n",
                name + "Field",
                field,
                currentClassName,
                StringUtils.capitalize(name),
                currentClassName,
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
    private CodeBlock generateRecordField(String name, String fieldTargetName,Function<String, MetaInfoRecord> getRecord) {
        ClassName rImplT = ClassName.get("",getRecord.apply(fieldTargetName).getClassName() + "Impl");
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(getRecord.apply(fieldTargetName).getClassName()));
        return CodeBlock.of("$N = new $T<>(this,$T.class, $N::get$N, $N::set$N)",
                name + "Field",
                rImplT,
                JpaImplT,
                currentClassName,
                StringUtils.capitalize(name),
                currentClassName,
                StringUtils.capitalize(name));
    }
}
