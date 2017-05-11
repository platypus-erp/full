package org.platypus.erp.module.base.models;

import org.platypus.api.fields.StringField;
import org.platypus.api.query.Filter;
import org.platypus.api.query.SearchBuilder;
import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BasePool;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import java.util.List;
import java.util.stream.Collectors;

import static org.platypus.api.query.SearchBuilder.*;

/**
 * Created by apasquier on 04/05/17.
 */
public class UserBusiness {


    public void onChangeLogin(BaseUsersRecord record) {
        if (record.login().match("")) {

        }


        QueryBuilder.Predicate query = QueryBuilder.eq(record.login(), "sdlfmsd");
        record.partner().id().getPath();
    }

    static BasePool pool;
    static BasePool.TestPool pool2;


    public static void main(String[] args) {
        Filter.Complexe<BaseUsersRecord> my_filter = r -> and(r.active().isUnSet(), r.active().isTrue());


        ImplUsersJPA record = new ImplUsersJPA();
//        System.out.println(record.getPath());
//        System.out.println(record.partner().getPath());
        BasePartnerRecord rp = record.partner();
        System.out.println(record.getPath());
        System.out.println(rp.getPath());
        System.out.println(rp.id().getPath());
        System.out.println(record.share().getPath());


        QueryBuilder.Predicate pre = QueryBuilder.eq(record.active(), true);
        System.out.println(pre);


        BaseUsersRecord rec = pool.getUser();

        BasePool.TestUserRecord rec2 = pool2.getUser();


        SearchBuilder<BaseUsersRecord> loginActive = search(rec);
        loginActive
                .get(BaseUsersRecord::active)
                .get(BaseUsersRecord::id)
                .get(BaseUsersRecord::login)
                .get(r -> r.partner().id())
                .get(BaseUsersRecord::partner)
                .filter(
                        or(record.active().isTrue(),
                                and(
                                        record.active().isFalse(),
                                        record.active().isUnSet()
                                )
                        )
                ).filter(my_filter)
                .sortAsc(record.id());
    }

    Filter.Basic<BaseUsersRecord> my_filter2 = r -> r.active().isUnSet();
}
