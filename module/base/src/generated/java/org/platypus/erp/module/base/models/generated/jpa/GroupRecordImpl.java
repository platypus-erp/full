package org.platypus.erp.module.base.models.generated.jpa;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.GroupRecord;

public class GroupRecordImpl extends RecordImpl<GroupRecord, ImplGroupJPA> implements GroupRecord {
  public GroupRecordImpl(Supplier<ImplGroupJPA> getter, Consumer<ImplGroupJPA> setter) {
    super(getter, setter);
  }
}
