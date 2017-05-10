package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.String;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecordCollection;

public class BasePartnerRecordCollectionImpl
        extends RecordCollectionImpl<BasePartnerRecord, ImplPartnerJPA, BasePartnerRecordCollection>
        implements BasePartnerRecordCollection {
  public BasePartnerRecordCollectionImpl(String name, Supplier<QueryPath> getPath,
      Supplier<List<ImplPartnerJPA>> getter, Consumer<List<ImplPartnerJPA>> setter) {
    super(ImplPartnerJPA.MODEL_NAME, name, getPath, getter, setter);
  }

  @Override
  public QueryPath resolve(QueryPath queryPath) {
    return getPath().resolve(queryPath);
  }
}
