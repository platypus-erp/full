package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.builder.core.internal.literral.DecimalFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

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
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            readonly = ValuesUtils.bool(def.readonly(), this.readonly);
            required = ValuesUtils.bool(def.required(), this.required);
            defaultValue = ValuesUtils.str(def.defaultValue(), this.defaultValue);
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
