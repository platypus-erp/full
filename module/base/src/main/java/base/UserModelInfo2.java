package base;

import org.platypus.api.SuperMethod;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord2;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/05/17.
 */
public interface UserModelInfo2 extends UserModelInfo{

    BaseUsersRecord2 newRecord();

}
