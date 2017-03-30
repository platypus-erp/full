package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.builder.core.plugin.impl.literral.TimeFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;

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
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            readonly = bool(def.readonly(), this.readonly);
            required = bool(def.required(), this.required);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            defaultNow = bool(def.defaultNow(), this.defaultNow);
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
