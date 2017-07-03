package org.platypus.erp.module.base;

import org.platypus.api.annotations.Service;
import org.platypus.erp.module.BaseUserService;
import org.platypus.erp.module.base.models.Users;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class Inherit1 implements BaseUserService.MyBusinessMethod {


    @Override
//    @Service.Multi
    public List<String> myBusinessMethod(List<String> record, String tt, BaseUserService.MyBusinessMethod.Super Super) {
        System.out.println(this.getClass().getName());
        record = Super.myBusinessMethod(record, tt);
        record.add(tt + "1");
        return record;
    }

//    @Service.Multi
    public List<String> myBusinessMethod2(List<String> record, String tt, BaseUserService.MyBusinessMethod.Super Super) {
        System.out.println(this.getClass().getName());
        record = Super.myBusinessMethod(record, tt);
        record.add(tt + "1");
        return record;
    }
}
