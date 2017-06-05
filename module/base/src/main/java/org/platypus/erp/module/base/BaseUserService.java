package org.platypus.erp.module.base;

import org.platypus.api.ServiceApi;
import org.platypus.api.annotations.Service;
import org.platypus.erp.module.base.models.Users;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public interface BaseUserService extends ServiceApi {

    @Service(Users.class)
    @FunctionalInterface
    interface MyBusinessMethod {
        @FunctionalInterface
        @Service.Super
        interface Super {
            List<String> myBusinessMethod(List<String> record, String tt);
        }
        @Service.Multi
        List<String> myBusinessMethod(List<String> record, String tt, BaseUserService.MyBusinessMethod.Super sup);

    }
}
