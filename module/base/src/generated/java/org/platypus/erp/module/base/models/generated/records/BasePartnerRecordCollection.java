package org.platypus.erp.module.base.models.generated.records;

import java.lang.Override;
import java.lang.String;
import org.platypus.api.RecordCollection;
import org.platypus.api.annotations.record.RecordOf;

@RecordOf(
      modelPkg = "org.platypus.erp.module.base.models",
      modelClassName = "Partner",
      modelName = "partner"
)
public interface BasePartnerRecordCollection extends RecordCollection<BasePartnerRecord> {
   @Override
   default String getTableName() {
      return "partner";
   }
}
