package org.platypus.erp.module.base.generated.models.generated.jpa;

import java.lang.Class;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.generated.models.generated.records.PartnerRecord;
import org.platypus.erp.module.base.generated.models.generated.records.PartnerRecordCollection;

public class PartnerRecordCollectionImpl<T extends Record> extends RecordCollectionImpl<T, PartnerRecord, ImplPartnerJPA, PartnerRecordCollection> implements PartnerRecordCollection {
  public PartnerRecordCollectionImpl(T instance, Class<ImplPartnerJPA> recordTarget,
      Function<T, List<ImplPartnerJPA>> getter, BiConsumer<T, List<ImplPartnerJPA>> setter) {
    super(instance, recordTarget, getter, setter);}
}
