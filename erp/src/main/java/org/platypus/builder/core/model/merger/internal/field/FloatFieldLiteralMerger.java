package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.builder.core.internal.literral.FloatFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

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
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            readonly = ValuesUtils.bool(def.readonly(), this.readonly);
            required = ValuesUtils.bool(def.required(), this.required);
            defaultValue = ValuesUtils.fltMin(def.defaultValue(), this.defaultValue);
            min = ValuesUtils.fltMin(def.min(), this.min);
            max = ValuesUtils.fltMax(def.max(), this.max);
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
