package base;

import org.platypus.api.SuperMethod;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/05/17.
 */
public interface UserModelInfo {

    BaseUsersRecord newRecord();

    <R extends BaseUsersRecord> R test(R rec, SuperMethod<R> sup);
}
