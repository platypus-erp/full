package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.annotations.field.RemoveSpaceType;
import org.platypus.api.annotations.field.RequiredType;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.builder.core.plugin.impl.literral.StringFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;
import static org.platypus.builder.utils.ValuesUtils.intMax;
import static org.platypus.builder.utils.ValuesUtils.intMin;
import static org.platypus.builder.utils.ValuesUtils.str;

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
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            removeSpace = def.removeSpace() == RemoveSpaceType.NONE ? this.removeSpace : def.removeSpace();
            required = def.required() == RequiredType.NONE ? this.required : def.required();
            defaultValue = str(def.defaultValue(), this.defaultValue);
            match = str(def.match(), this.match);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            maxSize = intMax(def.maxSize(), maxSize);
            minSize = intMin(def.minSize(), minSize);
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
