package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.builder.core.internal.literral.BigStringFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

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
            super.insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            super.updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            super.required = ValuesUtils.bool(def.required(), this.required);
            super.lazy = ValuesUtils.bool(def.lazy(), this.lazy);
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
