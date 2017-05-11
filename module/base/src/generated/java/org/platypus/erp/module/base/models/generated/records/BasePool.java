package org.platypus.erp.module.base.models.generated.records;

import org.platypus.api.Pool;

/**
 * Created by apasquier on 11/05/17.
 */
public interface BasePool extends Pool {

    BaseCompanyRecord getCompany();
    BaseGroupRecord getGroup();
    BasePartnerRecord getPartner();
    BaseUsersRecord getUser();


    interface TestPool extends BasePool{
        TestUserRecord getUser();
    }

    interface TestUserRecord extends BaseUsersRecord{

    }
}
