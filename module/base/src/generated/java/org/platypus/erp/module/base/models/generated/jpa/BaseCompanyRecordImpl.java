package org.platypus.erp.module.base.models.generated.jpa;

import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseCompanyRecordImpl
        extends RecordImpl<BaseCompanyRecord, ImplCompanyJPA>
        implements BaseCompanyRecord {
    public BaseCompanyRecordImpl(String table, String column, Supplier<QueryPath> getPath,
                                 Supplier<ImplCompanyJPA> getter, Consumer<ImplCompanyJPA> setter) {
        super(table, column, getPath, getter, setter, ImplCompanyJPA::new);
    }

    @Override
    public QueryPath resolve(QueryPath queryPath) {
        return getPath().resolve(queryPath);
    }



    @Override
    public LongField id() {
        return getOrDefault().id();
    }
}
