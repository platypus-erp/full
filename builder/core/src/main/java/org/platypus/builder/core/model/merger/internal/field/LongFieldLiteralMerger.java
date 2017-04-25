package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.builder.core.internal.literral.LongFieldLitteral;

import static org.platypus.builder.utils.ValuesUtils.bool;
import static org.platypus.builder.utils.ValuesUtils.longMax;

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
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            readonly = bool(def.readonly(), this.readonly);
            required = bool(def.required(), this.required);
            defaultValue = longMax(def.defaultValue(), this.defaultValue);
            min = longMax(def.min(), this.min);
            max = longMax(def.max(), this.max);
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
