package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.builder.core.internal.literral.TimeFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TimeFieldLiteralMerger extends TimeFieldLiteral implements FieldMerger<MetaInfoTimeField>{

    public TimeFieldLiteralMerger(MetaInfoTimeField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public TimeFieldLiteralMerger merge(MetaInfoTimeField def) {
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
    public MetaInfoTimeField toValue() {
        return this;
    }
}
