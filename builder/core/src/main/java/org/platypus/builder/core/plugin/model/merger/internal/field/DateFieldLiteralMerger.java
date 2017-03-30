package org.platypus.builder.core.plugin.model.merger.internal.field;


import org.platypus.api.annotations.field.DateTimeRelative;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.builder.core.plugin.impl.literral.DateFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class DateFieldLiteralMerger extends DateFieldLiteral implements FieldMerger<MetaInfoDateField>{

    public DateFieldLiteralMerger(MetaInfoDateField field) {
        super(field.getName());
        merge(field);
    }

    @Override
    public DateFieldLiteralMerger merge(MetaInfoDateField def) {
        if (def.eraseWithYours()) {
            insertable = bool(def.insertable(), this.insertable);
            updatable = bool(def.updatable(), this.updatable);
            readonly = bool(def.readonly(), this.readonly);
            required = bool(def.required(), this.required);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            defaultNow = bool(def.defaultToday(), this.defaultNow);
            relative = def.relative() == DateTimeRelative.NONE ? this.relative : def.relative();
        } else {
            insertable = def.insertable();
            updatable = def.updatable();
            readonly = def.readonly();
            required = def.required();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            defaultNow = def.defaultToday();
            relative = def.relative();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoDateField toValue() {
        return this;
    }
}
