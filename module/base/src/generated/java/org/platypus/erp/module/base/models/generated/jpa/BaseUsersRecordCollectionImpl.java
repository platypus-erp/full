package org.platypus.erp.module.base.models.generated.jpa;

import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecordCollection;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseUsersRecordCollectionImpl
        extends RecordCollectionImpl<BaseUsersRecord, ImplUsersJPA, BaseUsersRecordCollection>
        implements BaseUsersRecordCollection {
    public BaseUsersRecordCollectionImpl(String name,
                                         Supplier<QueryPath> getPath,
                                         Supplier<List<ImplUsersJPA>> getter,
                                         Consumer<List<ImplUsersJPA>> setter) {
        super(ImplUsersJPA.MODEL_NAME, name, getPath, getter, setter);
    }

    @Override
    public QueryPath resolve(QueryPath queryPath) {
        return getPath().resolve(queryPath);
    }
}
