package org.platypus.erp.module.base.models;

import org.platypus.erp.module.base.models.generated.records.UserRecord;

/**
 * Created by apasquier on 04/05/17.
 */
public class UserBusiness {


    public void onChangeLogin(UserRecord record) {
        if (record.login().match("")){
//            record.
        }
    }
}
