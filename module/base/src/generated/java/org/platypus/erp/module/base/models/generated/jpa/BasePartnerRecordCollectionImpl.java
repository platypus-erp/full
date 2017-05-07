package org.platypus.erp.module.base.models.generated.jpa;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecordCollection;

public class BasePartnerRecordCollectionImpl extends RecordCollectionImpl<BasePartnerRecord, ImplPartnerJPA, BasePartnerRecordCollection> implements BasePartnerRecordCollection {
  public BasePartnerRecordCollectionImpl(Supplier<List<ImplPartnerJPA>> getter,
      Consumer<List<ImplPartnerJPA>> setter) {
    super(getter, setter);
  }
}
