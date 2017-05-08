package org.platypus.builder.core.model.merger.internal.field;


import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.builder.core.internal.literral.ManyToManyFieldLiteral;
import org.platypus.builder.core.internal.literral.ManyToOneFieldLiteral;

import static org.platypus.builder.utils.ValuesUtils.bool;
import static org.platypus.builder.utils.ValuesUtils.str;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class MtoFieldLiteralMerger extends ManyToOneFieldLiteral
        implements FieldMerger<MetaInfoManyToOneField>{

    public MtoFieldLiteralMerger(MetaInfoManyToOneField field) {
        super(field.getName());
        targettFqn = field.target();
        merge(field);
    }

    @Override
    public MtoFieldLiteralMerger merge(MetaInfoManyToOneField def) {
        this.cascade = def.cascade();
        if (def.eraseWithYours()) {
            this.updatable = bool(def.updatable(), this.updatable);
            this.required = bool(def.required(), this.required);
            this.readonly = bool(def.readonly(), this.readonly);
            this.where = str(def.where(), this.where);
            this.sortAsc = str(def.where(), this.sortAsc);
            this.sortDesc = str(def.where(), this.sortDesc);
            this.columnDoc = def.columnDoc();
        } else {
            this.updatable = def.updatable();
            this.required = def.required();
            this.columnDoc = def.columnDoc();
            this.sortAsc = def.sortAsc();
            this.where = def.where();
            this.sortDesc = def.sortDesc();
            this.readonly = def.readonly();
        }
        eraseWithYours = false;
        return this;
    }

    @Override
    public MetaInfoManyToOneField toValue() {
        return this;
    }
}