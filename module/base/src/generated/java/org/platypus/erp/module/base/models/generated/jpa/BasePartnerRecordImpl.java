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
        super(ImplPartnerJPA.MODEL_NAME, name, getPath, getter, setter, (s) -> () -> new ImplPartnerJPA(s));
    }

    protected BasePartnerRecordImpl() {
        super(ImplPartnerJPA.MODEL_NAME, "id", (s) -> () -> new ImplPartnerJPA(s));
    }

    protected BasePartnerRecordImpl(Supplier<QueryPath> getPath) {
        super(ImplPartnerJPA.MODEL_NAME, "id", getPath, (s) -> () -> new ImplPartnerJPA(s));
    }

    @Override
    public LongField id() {
        return getDefaultValue().id();
    }
}
