package org.platypus.erp.module.base;

import org.platypus.api.annotations.Service;
import org.platypus.api.service.PlatypusService;
import org.platypus.erp.module.base.models.Users;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
@Service(Users.class)
public class Inherit0 extends PlatypusService<BaseUsersRecord>{


    @Service.Multi
    public List<String> myBusinessMethod(List<String> record, String tt) {
        System.out.println(this.getClass().getName());
        record.add(tt);
        return record;
    }
}
