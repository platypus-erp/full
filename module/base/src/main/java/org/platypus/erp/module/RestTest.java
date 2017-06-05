package org.platypus.erp.module;

import org.platypus.erp.module.base.BaseUserService;
import org.platypus.erp.module.base.Inherit0;
import org.platypus.erp.module.base.Inherit1;
import org.platypus.erp.module.base.Inherit2;
import org.platypus.erp.module.base.Inherit3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class RestTest implements BaseUserService.MyBusinessMethod.Super{

    Inherit0 inherit0 = new Inherit0();
    Inherit1 inherit1 = new Inherit1();
    Inherit2 inherit2 = new Inherit2();
    Inherit3 inherit3 = new Inherit3();

    public static void main(String[] args) {
        RestTest rt = new RestTest();
        System.out.println(rt.myBusinessMethod(new ArrayList<>(), "platypus"));
    }


    @Override
    public List<String> myBusinessMethod(List<String> record, String tt) {
        BaseUserService.MyBusinessMethod.Super root =
                (p1, p2) -> this.inherit0.myBusinessMethod(p1, p2);


        BaseUserService.MyBusinessMethod.Super inherit1M =
                (p1, p2) -> this.inherit1.myBusinessMethod(p1, p2, root);

        BaseUserService.MyBusinessMethod.Super inherit2M =
                (p1, p2) -> this.inherit2.myBusinessMethod(p1, p2, inherit1M);


        return inherit3.myBusinessMethod(record, tt, inherit2M);
    }
}
