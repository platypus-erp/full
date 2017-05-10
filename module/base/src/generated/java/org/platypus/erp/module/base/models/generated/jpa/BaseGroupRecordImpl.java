package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;

public class BaseGroupRecordImpl extends RecordImpl<BaseGroupRecord, ImplGroupJPA> implements BaseGroupRecord {
    public BaseGroupRecordImpl(String name, Supplier<QueryPath> getPath,
                               Supplier<ImplGroupJPA> getter, Consumer<ImplGroupJPA> setter) {
        super(ImplGroupJPA.MODEL_NAME, name, getPath, getter, setter, (s) -> () -> new ImplGroupJPA(s));
    }

    protected BaseGroupRecordImpl() {
        super(ImplGroupJPA.MODEL_NAME, "id", (s) -> () -> new ImplGroupJPA(s));
    }

    protected BaseGroupRecordImpl(Supplier<QueryPath> getPath) {
        super(ImplGroupJPA.MODEL_NAME, "id", getPath, (s) -> () -> new ImplGroupJPA(s));
    }

    @Override
    public LongField id() {
        return getOrDefault().id();
    }
}
