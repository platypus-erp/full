package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.String;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecordCollection;

public class BaseCompanyRecordCollectionImpl extends RecordCollectionImpl<BaseCompanyRecord, ImplCompanyJPA, BaseCompanyRecordCollection> implements BaseCompanyRecordCollection {
  public BaseCompanyRecordCollectionImpl(String table, String name, Supplier<QueryPath> getPath,
      Supplier<List<ImplCompanyJPA>> getter, Consumer<List<ImplCompanyJPA>> setter) {
    super(table, name, getPath, getter, setter);
  }
}
