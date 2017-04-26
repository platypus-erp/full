package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Class;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.CompanyRecord;
import org.platypus.erp.module.base.models.generated.records.CompanyRecordCollection;

public class CompanyRecordCollectionImpl<T extends Record> extends RecordCollectionImpl<T, CompanyRecord, ImplCompanyJPA, CompanyRecordCollection> implements CompanyRecordCollection {
  public CompanyRecordCollectionImpl(T instance, Class<ImplCompanyJPA> recordTarget,
      Function<T, List<ImplCompanyJPA>> getter, BiConsumer<T, List<ImplCompanyJPA>> setter) {
    super(instance, recordTarget, getter, setter);}
}
