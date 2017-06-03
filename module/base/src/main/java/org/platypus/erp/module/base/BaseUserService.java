package org.platypus.erp.module.base;

import org.platypus.api.annotations.Service;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public interface BaseUserService {

    @Service(service = Inherit0.class, name = "myBusinessMethod")
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
