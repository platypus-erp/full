package base;

import org.platypus.api.Pool;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

public interface BaseRecordPool extends Pool{

   BaseUsersRecord getUsers();
}
