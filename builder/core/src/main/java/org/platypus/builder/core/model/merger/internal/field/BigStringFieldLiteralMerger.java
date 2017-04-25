package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.builder.core.internal.literral.BigStringFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BigStringFieldLiteralMerger extends BigStringFieldLiteral implements FieldMerger<MetaInfoBigStringField> {

    public BigStringFieldLiteralMerger(MetaInfoBigStringField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public BigStringFieldLiteralMerger merge(MetaInfoBigStringField def) {
        if (def.eraseWithYours()) {
            super.insertable = bool(def.insertable(), this.insertable);
            super.updatable = bool(def.updatable(), this.updatable);
            super.required = bool(def.required(), this.required);
            super.lazy = bool(def.lazy(), this.lazy);
            super.columnDoc = def.columnDoc();
        } else {
            super.insertable = def.insertable();
            super.updatable = def.updatable();
            super.required = def.required();
            super.lazy = def.lazy();
            super.columnDoc = def.columnDoc();
        }
        super.eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoBigStringField toValue() {
        return this;
    }
}
