package org.platypus.erp.module.base.models.generated.jpa;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;

public class BaseCompanyRecordImpl extends RecordImpl<BaseCompanyRecord, ImplCompanyJPA> implements BaseCompanyRecord {
  public BaseCompanyRecordImpl(Supplier<ImplCompanyJPA> getter, Consumer<ImplCompanyJPA> setter) {
    super(getter, setter);
  }
}
