package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Class;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.GroupRecord;
import org.platypus.erp.module.base.models.generated.records.GroupRecordCollection;

public class GroupRecordCollectionImpl<T extends Record> extends RecordCollectionImpl<T, GroupRecord, ImplGroupJPA, GroupRecordCollection> implements GroupRecordCollection {
  public GroupRecordCollectionImpl(T instance, Class<ImplGroupJPA> recordTarget,
      Function<T, List<ImplGroupJPA>> getter, BiConsumer<T, List<ImplGroupJPA>> setter) {
    super(instance, recordTarget, getter, setter);}
}
