package org.platypus.erp.module.base.models.generated.jpa;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecordCollection;

public class BaseGroupRecordCollectionImpl extends RecordCollectionImpl<BaseGroupRecord, ImplGroupJPA, BaseGroupRecordCollection> implements BaseGroupRecordCollection {
  public BaseGroupRecordCollectionImpl(Supplier<List<ImplGroupJPA>> getter,
      Consumer<List<ImplGroupJPA>> setter) {
    super(getter, setter);
  }
}
