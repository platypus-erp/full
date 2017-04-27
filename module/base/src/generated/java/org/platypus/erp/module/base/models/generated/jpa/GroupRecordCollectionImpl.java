package org.platypus.erp.module.base.models.generated.jpa;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.erp.module.base.models.generated.records.GroupRecord;
import org.platypus.erp.module.base.models.generated.records.GroupRecordCollection;

public class GroupRecordCollectionImpl extends RecordCollectionImpl<GroupRecord, ImplGroupJPA, GroupRecordCollection> implements GroupRecordCollection {
  public GroupRecordCollectionImpl(Supplier<List<ImplGroupJPA>> getter,
      Consumer<List<ImplGroupJPA>> setter) {
    super(getter, setter);
  }
}
