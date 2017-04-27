package org.platypus.erp.module.base.models.generated.jpa;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.PartnerRecord;
import org.platypus.erp.module.base.models.generated.records.PartnerRecordCollection;

public class PartnerRecordCollectionImpl extends RecordCollectionImpl<PartnerRecord, ImplPartnerJPA, PartnerRecordCollection> implements PartnerRecordCollection {
  public PartnerRecordCollectionImpl(Supplier<List<ImplPartnerJPA>> getter,
      Consumer<List<ImplPartnerJPA>> setter) {
    super(getter, setter);
  }
}
