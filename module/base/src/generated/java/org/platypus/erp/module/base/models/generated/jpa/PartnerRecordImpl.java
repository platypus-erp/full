package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Class;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.PartnerRecord;

public class PartnerRecordImpl<T extends Record> extends RecordImpl<T, PartnerRecord, ImplPartnerJPA> implements PartnerRecord {
  public PartnerRecordImpl(T instance, Class<ImplPartnerJPA> targetRecordImpl,
      Function<T, ImplPartnerJPA> getter, BiConsumer<T, ImplPartnerJPA> setter) {
    super(instance, targetRecordImpl, getter, setter);}
}
