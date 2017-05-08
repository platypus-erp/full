package org.platypus.erp.module.base.models;

import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

/**
 * Created by apasquier on 04/05/17.
 */
public class UserBusiness {


    public void onChangeLogin(BaseUsersRecord record) {
        if (record.login().match("")){
        }


        QueryBuilder.Predicate query = QueryBuilder.eq(record.login(), "sdlfmsd");
        record.partner().id().getPath();
    }


    public static void main(String[] args) {
        ImplUsersJPA record = new ImplUsersJPA();
        System.out.println(record.partner().id().getPath());
    }
}
