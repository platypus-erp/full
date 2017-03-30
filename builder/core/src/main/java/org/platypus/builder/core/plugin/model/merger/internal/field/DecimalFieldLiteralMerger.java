package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.builder.core.plugin.impl.literral.DecimalFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;
import static org.platypus.builder.utils.ValuesUtils.fltMax;
import static org.platypus.builder.utils.ValuesUtils.fltMin;
import static org.platypus.builder.utils.ValuesUtils.str;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DecimalFieldLiteralMerger extends DecimalFieldLiteral implements FieldMerger<MetaInfoDecimalField>{

    public DecimalFieldLiteralMerger(MetaInfoDecimalField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public DecimalFieldLiteralMerger merge(MetaInfoDecimalField def) {
        if (def.eraseWithYours()) {
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            readonly = bool(def.readonly(), this.readonly);
            required = bool(def.required(), this.required);
            defaultValue = str(def.defaultValue(), this.defaultValue);
            min = fltMin(def.min(), this.min);
            max = fltMax(def.max(), this.max);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            readonly = def.readonly();
            required = def.required();
            defaultValue = def.defaultValue();
            columnDoc = def.columnDoc();
            max = def.max();
            uniqueHint = def.uniqueHint();
            min = def.min();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoDecimalField toValue() {
        return this;
    }
}
