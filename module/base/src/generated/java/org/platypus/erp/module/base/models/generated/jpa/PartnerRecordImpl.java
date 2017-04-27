package org.platypus.erp.module.base.models.generated.jpa;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.PartnerRecord;

public class PartnerRecordImpl extends RecordImpl<PartnerRecord, ImplPartnerJPA> implements PartnerRecord {
  public PartnerRecordImpl(Supplier<ImplPartnerJPA> getter, Consumer<ImplPartnerJPA> setter) {
    super(getter, setter);
  }
}
