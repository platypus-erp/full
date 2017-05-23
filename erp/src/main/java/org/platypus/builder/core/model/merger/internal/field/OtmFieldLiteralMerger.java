package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.builder.core.internal.literral.OneToManyFieldLiteral;
import org.platypus.builder.utils.ValuesUtils;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class OtmFieldLiteralMerger extends OneToManyFieldLiteral
        implements FieldMerger<MetaInfoOneToManyField>{

    public OtmFieldLiteralMerger(MetaInfoOneToManyField field) {
        super(field.getName());
        targettFqn = field.target();
        merge(field);
    }

    @Override
    public OtmFieldLiteralMerger merge(MetaInfoOneToManyField def) {
        this.cascade = def.cascade();
        if (def.eraseWithYours()) {
            updatable = ValuesUtils.bool(def.updatable(), this.updatable);
            required = ValuesUtils.bool(def.required(), this.required);
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            mappedBy = def.mappedBy();
            orphanRemoval = ValuesUtils.bool(def.orphanRemoval(), this.orphanRemoval);
            readonly = ValuesUtils.bool(def.orphanRemoval(), this.readonly);
        } else {
            updatable = def.updatable();
            required = def.required();
            columnDoc = def.columnDoc();
            uniqueHint = def.uniqueHint();
            orphanRemoval = def.orphanRemoval();
            mappedBy = def.mappedBy();
            readonly = def.readonly();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoOneToManyField toValue() {
        return this;
    }
}
