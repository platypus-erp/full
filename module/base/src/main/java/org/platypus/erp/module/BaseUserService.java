package org.platypus.erp.module;

import org.platypus.api.ServiceApi;
import org.platypus.api.annotations.Service;
import org.platypus.api.annotations.ServiceInfo;
import org.platypus.api.annotations.ServiceInfoType;
import org.platypus.erp.module.base.Inherit0;
import org.platypus.erp.module.base.models.Users;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public interface BaseUserService extends ServiceApi {

    @ServiceInfo(model = Users.class, classHolder = Inherit0.class)
    @FunctionalInterface
    interface MyBusinessMethod extends ServiceInfoType{
        @FunctionalInterface
        @Service.Super
        interface Super {
            List<String> myBusinessMethod(List<String> record, String tt);
        }
        @Service.Multi
        List<String> myBusinessMethod(List<String> record, String tt, Super sup);
    }
}
