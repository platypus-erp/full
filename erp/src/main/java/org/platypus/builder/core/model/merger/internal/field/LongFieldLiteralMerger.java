package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.builder.core.internal.literral.LongFieldLitteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class LongFieldLiteralMerger extends LongFieldLitteral implements FieldMerger<MetaInfoLongField>{

    public LongFieldLiteralMerger(MetaInfoLongField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public LongFieldLiteralMerger merge(MetaInfoLongField def) {
        if (def.eraseWithYours()) {
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            readonly = ValuesUtils.bool(def.readonly(), this.readonly);
            required = ValuesUtils.bool(def.required(), this.required);
            defaultValue = ValuesUtils.longMax(def.defaultValue(), this.defaultValue);
            min = ValuesUtils.longMax(def.min(), this.min);
            max = ValuesUtils.longMax(def.max(), this.max);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            readonly = def.readonly();
            required = def.required();
            defaultValue = def.defaultValue();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            min = def.min();
            max = def.max();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoLongField toValue() {
        return this;
    }
}
