package org.platypus.erp.module.base.models;

import base.BaseRecordPool;
import org.platypus.api.query.Filter;
import org.platypus.api.query.SearchBuilder;
import org.platypus.api.query.SearchResult;
import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

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

    static BaseRecordPool pool;


    public static void main(String[] args) {


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


        BaseUsersRecord rec = pool.getUsers();


        SearchResult<BaseUsersRecord> loginActive = new SearchBuilder()
                .add(rec.new_password())
                .add(rec.id())
                .add(rec.login())
                .add(rec.partner().id())
                .add(rec.partner())
                .where(rec.active()).isFalse()
                .and(rec.login()).contains("toto")
                .or(rec.new_password()).eq(null)
                .execute(rec);


    }

}
