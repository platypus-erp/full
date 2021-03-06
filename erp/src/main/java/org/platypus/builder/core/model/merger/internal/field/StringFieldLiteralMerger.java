package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.annotations.field.RemoveSpaceType;
import org.platypus.api.annotations.field.RequiredType;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.builder.core.internal.literral.StringFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public final class StringFieldLiteralMerger extends StringFieldLiteral implements FieldMerger<MetaInfoStringField> {

    public StringFieldLiteralMerger(MetaInfoStringField field) {
        super(field.getName());
        merge(field);
    }
    @Override
    public StringFieldLiteralMerger merge(MetaInfoStringField def) {
        if (!def.eraseWithYours()) {
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            removeSpace = def.removeSpace() == RemoveSpaceType.NONE ? this.removeSpace : def.removeSpace();
            required = def.required() == RequiredType.NONE ? this.required : def.required();
            defaultValue = ValuesUtils.str(def.defaultValue(), this.defaultValue);
            match = ValuesUtils.str(def.match(), this.match);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            maxSize = ValuesUtils.intMax(def.maxSize(), maxSize);
            minSize = ValuesUtils.intMin(def.minSize(), minSize);
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            required = def.required();
            removeSpace = def.removeSpace();
            defaultValue = def.defaultValue();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            maxSize = def.maxSize();
            minSize = def.minSize();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoStringField toValue() {
        return this;
    }
}
