package org.platypus.erp.module.base.generated.models.generated.jpa;

import java.lang.Class;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.generated.models.generated.records.CompanyRecord;

public class CompanyRecordImpl<T extends Record> extends RecordImpl<T, CompanyRecord, ImplCompanyJPA> implements CompanyRecord {
  public CompanyRecordImpl(T instance, Class<ImplCompanyJPA> targetRecordImpl,
      Function<T, ImplCompanyJPA> getter, BiConsumer<T, ImplCompanyJPA> setter) {
    super(instance, targetRecordImpl, getter, setter);}
}
