package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;

public class BasePartnerRecordImpl extends RecordImpl<BasePartnerRecord, ImplPartnerJPA> implements BasePartnerRecord {
    public BasePartnerRecordImpl(String name, Supplier<QueryPath> getPath,
                                 Supplier<ImplPartnerJPA> getter, Consumer<ImplPartnerJPA> setter) {
        super(ImplPartnerJPA.MODEL_NAME, name, getPath, getter, setter, ImplPartnerJPA::new);
    }

    @Override
    public QueryPath resolve(QueryPath queryPath) {
        return super.resolve(queryPath);
    }

    @Override
    public LongField id() {
        return getDefaultValue().id();
    }
}
