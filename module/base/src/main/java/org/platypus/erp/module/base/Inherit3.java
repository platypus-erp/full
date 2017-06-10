package org.platypus.erp.module.base;

import org.platypus.erp.module.BaseUserService;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class Inherit3 implements BaseUserService.MyBusinessMethod{

    @Override
    public List<String> myBusinessMethod(List<String> record, String tt, BaseUserService.MyBusinessMethod.Super Super) {
        System.out.println(this.getClass().getName());
        record = Super.myBusinessMethod(record, tt);
        record.add(tt + "3");
        return record;
    }
}
