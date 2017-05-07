package org.platypus.erp.module.base.models.generated.jpa;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;

public class BaseGroupRecordImpl extends RecordImpl<BaseGroupRecord, ImplGroupJPA> implements BaseGroupRecord {
  public BaseGroupRecordImpl(Supplier<ImplGroupJPA> getter, Consumer<ImplGroupJPA> setter) {
    super(getter, setter);
  }
}
