package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeName;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.builder.plugin.internal.Utils;
import org.platypus.builder.utils.javapoet.utils.FieldSpecUtils;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordGenerator {
    public FieldSpec generateField(MetaInfoBigStringField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoBinaryField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoBooleanField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDateField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDateTimeField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoDecimalField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoFloatField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoIntField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoLongField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoStringField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    public FieldSpec generateField(MetaInfoTimeField field){
        return getField(field.getName(), Utils.getRecordFieldInterface(field));
    }
    private FieldSpec getField(String name, TypeName field){
        return FieldSpecUtils.privateFinalField(field, name+"InheritField");
    }
}
