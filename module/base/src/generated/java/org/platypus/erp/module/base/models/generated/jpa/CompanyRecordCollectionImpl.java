package org.platypus.erp.module.base.models.generated.jpa;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.CompanyRecord;
import org.platypus.erp.module.base.models.generated.records.CompanyRecordCollection;

public class CompanyRecordCollectionImpl extends RecordCollectionImpl<CompanyRecord, ImplCompanyJPA, CompanyRecordCollection> implements CompanyRecordCollection {
  public CompanyRecordCollectionImpl(Supplier<List<ImplCompanyJPA>> getter,
      Consumer<List<ImplCompanyJPA>> setter) {
    super(getter, setter);
  }
}
