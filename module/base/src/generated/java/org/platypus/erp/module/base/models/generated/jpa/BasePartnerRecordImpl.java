package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.query.tmp.QueryPathImpl;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;

public class BasePartnerRecordImpl extends RecordImpl<BasePartnerRecord, ImplPartnerJPA> implements BasePartnerRecord {
  public BasePartnerRecordImpl(String table, String name, Supplier<QueryPathImpl> getPath,
      Supplier<ImplPartnerJPA> getter, Consumer<ImplPartnerJPA> setter) {
    super(table, name, getPath, getter, setter, ImplPartnerJPA::new);
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }
}
