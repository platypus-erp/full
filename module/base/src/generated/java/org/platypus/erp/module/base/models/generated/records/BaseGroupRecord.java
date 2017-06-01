package org.platypus.erp.module.base.models.generated.records;

import java.lang.Override;
import java.lang.String;
import org.platypus.api.Record;
import org.platypus.api.annotations.record.RecordOf;

@RecordOf(
      modelPkg = "org.platypus.erp.module.base.models",
      modelClassName = "Group",
      modelName = "group"
)
public interface BaseGroupRecord extends Record {
   @Override
   default String getTableName() {
      return "group";
   }
}
