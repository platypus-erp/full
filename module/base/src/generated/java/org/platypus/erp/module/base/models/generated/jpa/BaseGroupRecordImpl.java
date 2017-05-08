package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.QueryPath;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;

public class BaseGroupRecordImpl extends RecordImpl<BaseGroupRecord, ImplGroupJPA> implements BaseGroupRecord {
  public BaseGroupRecordImpl(String name, Supplier<QueryPath> getPath,
      Supplier<ImplGroupJPA> getter, Consumer<ImplGroupJPA> setter) {
    super(name,getPath, getter, setter, ImplGroupJPA::new);
  }

  protected BaseGroupRecordImpl(String name) {
    super(name, ImplGroupJPA::new);
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }
}
