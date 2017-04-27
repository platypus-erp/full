package org.platypus.erp.module.base.generated.models.generated.jpa;

import java.lang.Class;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.generated.models.generated.records.UserRecord;
import org.platypus.erp.module.base.generated.models.generated.records.UserRecordCollection;

public class UserRecordCollectionImpl<T extends Record> extends RecordCollectionImpl<T, UserRecord, ImplUserJPA, UserRecordCollection> implements UserRecordCollection {
  public UserRecordCollectionImpl(T instance, Class<ImplUserJPA> recordTarget,
      Function<T, List<ImplUserJPA>> getter, BiConsumer<T, List<ImplUserJPA>> setter) {
    super(instance, recordTarget, getter, setter);}
}
