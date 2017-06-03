package org.platypus.erp.module.base;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class Inherit2 implements BaseUserService.MyBusinessMethod{

    @Override
    public List<String> myBusinessMethod(List<String> record, String tt, BaseUserService.MyBusinessMethod.Super Super) {
        System.out.println(this.getClass().getName());
        record = Super.myBusinessMethod(record, tt);
        record.add(tt + "2");
        return record;
    }
}
