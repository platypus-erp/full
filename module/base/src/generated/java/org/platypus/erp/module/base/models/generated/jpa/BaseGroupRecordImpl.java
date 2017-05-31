package org.platypus.erp.module.base.models.generated.jpa;

import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseGroupRecordImpl extends RecordImpl<BaseGroupRecord, ImplGroupJPA> implements BaseGroupRecord {
  public BaseGroupRecordImpl(String table, String name, Supplier<QueryPath> getPath,
      Supplier<ImplGroupJPA> getter, Consumer<ImplGroupJPA> setter) {
    super(table, name, getPath, getter, setter, ImplGroupJPA::new);
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }
}
