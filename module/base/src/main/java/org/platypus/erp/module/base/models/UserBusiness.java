package org.platypus.erp.module.base.models;

import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

/**
 * Created by apasquier on 04/05/17.
 */
public class UserBusiness {


    public void onChangeLogin(BaseUsersRecord record) {
        if (record.login().match("")){
        }


        QueryBuilder.Predicate query = QueryBuilder.eq(record.login(), "sdlfmsd");
        record.partner().getId().getPath();
    }
}
