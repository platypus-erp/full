package org.platypus.erp.module.base.models.generated.records;

import java.lang.Override;
import java.lang.String;
import org.platypus.api.RecordCollection;
import org.platypus.api.annotations.record.RecordOf;

@RecordOf(
      modelPkg = "org.platypus.erp.module.base.models",
      modelClassName = "Users",
      modelName = "users"
)
public interface BaseUsersRecordCollection extends RecordCollection<BaseUsersRecord> {
   @Override
   default String getTableName() {
      return "users";
   }
}
