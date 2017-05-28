package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.query.tmp.QueryPathImpl;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;

public class BaseCompanyRecordImpl extends RecordImpl<BaseCompanyRecord, ImplCompanyJPA> implements BaseCompanyRecord {
  public BaseCompanyRecordImpl(String table, String name, Supplier<QueryPathImpl> getPath,
      Supplier<ImplCompanyJPA> getter, Consumer<ImplCompanyJPA> setter) {
    super(table, name, getPath, getter, setter, ImplCompanyJPA::new);
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }
}
