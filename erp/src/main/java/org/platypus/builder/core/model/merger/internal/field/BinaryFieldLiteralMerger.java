package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.builder.core.internal.literral.BinaryFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BinaryFieldLiteralMerger extends BinaryFieldLiteral implements FieldMerger<MetaInfoBinaryField>{

    public BinaryFieldLiteralMerger(MetaInfoBinaryField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public BinaryFieldLiteralMerger merge(MetaInfoBinaryField def) {
        if (def.eraseWithYours()) {
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            required = ValuesUtils.bool(def.required(), this.required);
            lazy = ValuesUtils.bool(def.lazy(), this.lazy);
            columnDoc = def.columnDoc();
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            required = def.required();
            lazy = def.lazy();
            columnDoc = def.columnDoc();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoBinaryField toValue() {
        return this;
    }
}
