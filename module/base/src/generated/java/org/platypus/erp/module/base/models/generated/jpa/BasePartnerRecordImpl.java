package org.platypus.erp.module.base.models.generated.jpa;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;

public class BasePartnerRecordImpl extends RecordImpl<BasePartnerRecord, ImplPartnerJPA> implements BasePartnerRecord {
  public BasePartnerRecordImpl(Supplier<ImplPartnerJPA> getter, Consumer<ImplPartnerJPA> setter) {
    super(getter, setter);
  }
}
