package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.builder.core.internal.literral.BooleanFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

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
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            defaultValue = ValuesUtils.bool(def.defaultValue(), this.defaultValue);
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
