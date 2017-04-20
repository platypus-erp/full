package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.fields.metainfo.*;
import org.platypus.builder.utils.javapoet.utils.FieldSpecUtils;

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

    public CodeBlock generateField(MetaInfoBigStringField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoBinaryField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoBooleanField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoDateField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public CodeBlock generateField(MetaInfoDateTimeField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoDecimalField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoFloatField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoIntField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoLongField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoStringField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    public CodeBlock generateField(MetaInfoTimeField field){
        return getField(field.getName(), Utils.getRecordFieldImpl(field));
    }
    private CodeBlock getField(String name, TypeName field){
        return CodeBlock.of("$N = new $T<>(this, $N::get$N, $N::set$N);",
                name+"Field",
                field,
                currentClassName,
                StringUtils.capitalize(name),
                currentClassName,
                StringUtils.capitalize(name)
        );


    }
}
