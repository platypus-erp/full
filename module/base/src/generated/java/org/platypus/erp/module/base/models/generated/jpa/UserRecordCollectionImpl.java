package org.platypus.erp.module.base.models.generated.jpa;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.UserRecord;
import org.platypus.erp.module.base.models.generated.records.UserRecordCollection;

public class UserRecordCollectionImpl extends RecordCollectionImpl<UserRecord, ImplUserJPA, UserRecordCollection> implements UserRecordCollection {
  public UserRecordCollectionImpl(Supplier<List<ImplUserJPA>> getter,
      Consumer<List<ImplUserJPA>> setter) {
    super(getter, setter);
  }
}
