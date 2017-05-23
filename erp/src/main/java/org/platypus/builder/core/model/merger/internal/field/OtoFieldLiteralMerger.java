package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.builder.core.internal.literral.OneToOneFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class OtoFieldLiteralMerger extends OneToOneFieldLiteral
        implements FieldMerger<MetaInfoOneToOneField>{

    public OtoFieldLiteralMerger(MetaInfoOneToOneField field) {
        super(field.getName());
        targettFqn = field.target();
        merge(field);
    }

    @Override
    public OtoFieldLiteralMerger merge(MetaInfoOneToOneField def) {
        this.cascade = def.cascade();
        if (def.eraseWithYours()) {
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            required = ValuesUtils.bool(def.required(), this.required);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            mappedBy = def.mappedBy();
            readonly = ValuesUtils.bool(def.readonly(), this.readonly);
        } else {
            updatable = def.updatable();
            required = def.required();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            mappedBy = def.mappedBy();
            readonly = def.readonly();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoOneToOneField toValue() {
        return this;
    }
}
