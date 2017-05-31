package org.platypus.erp.module.base.models.generated.jpa;

import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseCompanyRecordImpl extends RecordImpl<BaseCompanyRecord, ImplCompanyJPA> implements BaseCompanyRecord {
  public BaseCompanyRecordImpl(String table, String name, Supplier<QueryPath> getPath,
      Supplier<ImplCompanyJPA> getter, Consumer<ImplCompanyJPA> setter) {
    super(table, name, getPath, getter, setter, ImplCompanyJPA::new);
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }
}
