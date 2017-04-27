package org.platypus.erp.module.base.models.generated.jpa;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.CompanyRecord;

public class CompanyRecordImpl extends RecordImpl<CompanyRecord, ImplCompanyJPA> implements CompanyRecord {
  public CompanyRecordImpl(Supplier<ImplCompanyJPA> getter, Consumer<ImplCompanyJPA> setter) {
    super(getter, setter);
  }
}
