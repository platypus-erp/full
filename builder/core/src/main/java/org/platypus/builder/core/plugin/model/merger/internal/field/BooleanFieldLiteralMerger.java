package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.builder.core.plugin.impl.literral.BooleanFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BooleanFieldLiteralMerger extends BooleanFieldLiteral implements FieldMerger<MetaInfoBooleanField> {

    public BooleanFieldLiteralMerger(MetaInfoBooleanField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public BooleanFieldLiteralMerger merge(MetaInfoBooleanField def) {
        if (def.eraseWithYours()) {
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            defaultValue = bool(def.defaultValue(), this.defaultValue);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            defaultValue = def.defaultValue();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoBooleanField toValue() {
        return this;
    }
}
