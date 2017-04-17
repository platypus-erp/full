package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.builder.core.internal.literral.FloatFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;
import static org.platypus.builder.utils.ValuesUtils.fltMax;
import static org.platypus.builder.utils.ValuesUtils.fltMin;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class FloatFieldLiteralMerger extends FloatFieldLiteral
        implements FieldMerger<MetaInfoFloatField>{

    public FloatFieldLiteralMerger(MetaInfoFloatField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public FloatFieldLiteralMerger merge(MetaInfoFloatField def) {
        if (def.eraseWithYours()) {
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            readonly = bool(def.readonly(), this.readonly);
            required = bool(def.required(), this.required);
            defaultValue = fltMin(def.defaultValue(), this.defaultValue);
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
            uniqueHint = def.uniqueHint();
            min = def.min();
            max = def.max();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoFloatField toValue() {
        return this;
    }
}
