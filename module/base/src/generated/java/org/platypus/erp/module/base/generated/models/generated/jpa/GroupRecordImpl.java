package org.platypus.erp.module.base.generated.models.generated.jpa;

import java.lang.Class;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.generated.models.generated.records.GroupRecord;

public class GroupRecordImpl<T extends Record> extends RecordImpl<T, GroupRecord, ImplGroupJPA> implements GroupRecord {
  public GroupRecordImpl(T instance, Class<ImplGroupJPA> targetRecordImpl,
      Function<T, ImplGroupJPA> getter, BiConsumer<T, ImplGroupJPA> setter) {
    super(instance, targetRecordImpl, getter, setter);}
}
