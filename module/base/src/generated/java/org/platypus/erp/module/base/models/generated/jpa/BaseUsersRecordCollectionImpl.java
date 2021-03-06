package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.String;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecordCollection;

public class BaseUsersRecordCollectionImpl extends RecordCollectionImpl<BaseUsersRecord, ImplUsersJPA, BaseUsersRecordCollection> implements BaseUsersRecordCollection {
  public BaseUsersRecordCollectionImpl(String table, String name, Supplier<QueryPath> getPath,
      Supplier<List<ImplUsersJPA>> getter, Consumer<List<ImplUsersJPA>> setter) {
    super(table, name, getPath, getter, setter);
  }
}
