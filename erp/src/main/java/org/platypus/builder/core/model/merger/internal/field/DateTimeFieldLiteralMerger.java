package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.builder.core.internal.literral.DateTimeFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DateTimeFieldLiteralMerger extends DateTimeFieldLiteral implements FieldMerger<MetaInfoDateTimeField> {

    public DateTimeFieldLiteralMerger(MetaInfoDateTimeField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public DateTimeFieldLiteralMerger merge(MetaInfoDateTimeField def) {
        if (def.eraseWithYours()) {
            insertable = ValuesUtils.bool(def.insertable(), this.insertable);
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            readonly = ValuesUtils.bool(def.readonly(), this.readonly);
            required = ValuesUtils.bool(def.required(), this.required);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            defaultNow = ValuesUtils.bool(def.defaultNow(), this.defaultNow);
            relative = def.relative() == DateTimeRelative.NONE ? this.relative : def.relative();
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            readonly = def.readonly();
            required = def.required();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            defaultNow = def.defaultNow();
            relative = def.relative();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoDateTimeField toValue() {
        return this;
    }
}
