package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;

public class BaseCompanyRecordImpl extends RecordImpl<BaseCompanyRecord, ImplCompanyJPA> implements BaseCompanyRecord {
  public BaseCompanyRecordImpl(String table, String column, Supplier<QueryPath> getPath,
      Supplier<ImplCompanyJPA> getter, Consumer<ImplCompanyJPA> setter) {
    super(table, column,getPath, getter, setter, (s) -> () -> new ImplCompanyJPA(s));
  }

  protected BaseCompanyRecordImpl() {
    super(ImplCompanyJPA.MODEL_NAME, "id", (s) -> () -> new ImplCompanyJPA(s));
  }

  protected BaseCompanyRecordImpl(Supplier<QueryPath> getPath) {
    super(ImplCompanyJPA.MODEL_NAME, "id", getPath, (s) -> () -> new ImplCompanyJPA(s));
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }
}
