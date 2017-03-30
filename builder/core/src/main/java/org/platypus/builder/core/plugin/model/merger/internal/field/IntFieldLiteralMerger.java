package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.builder.core.plugin.impl.literral.IntFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;
import static org.platypus.builder.utils.ValuesUtils.intMax;
import static org.platypus.builder.utils.ValuesUtils.intMin;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class IntFieldLiteralMerger extends IntFieldLiteral implements FieldMerger<MetaInfoIntField>{

    public IntFieldLiteralMerger(MetaInfoIntField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public IntFieldLiteralMerger merge(MetaInfoIntField def) {
        if (def.eraseWithYours()) {
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            readonly = bool(def.readonly(), this.readonly);
            required = bool(def.required(), this.required);
            defaultValue = intMin(def.defaultValue(), this.defaultValue);
            min = intMin(def.min(), this.min);
            max = intMax(def.max(), this.max);
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
    public MetaInfoIntField toValue() {
        return this;
    }
}
