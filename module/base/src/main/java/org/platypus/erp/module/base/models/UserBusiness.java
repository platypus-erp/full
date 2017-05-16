package org.platypus.erp.module.base.models;

import base.BaseRecordPool;
import org.platypus.api.fields.StringField;
import org.platypus.api.query.PredicateCombinator;
import org.platypus.api.query.SearchBuilder;
import org.platypus.api.query.predicate.PredicateBuilder;
import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import static org.platypus.api.query.PredicateCombinator.AND;


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






        SearchBuilder<BaseUsersRecord> loginActive = SearchBuilder.from(BaseUsersRecord.class)
                .add(BaseUsersRecord::partner)
                .add(BaseUsersRecord::login)
                .add(r -> r.partner().id())
                .add(new PredicateBuilder<BaseUsersRecord>().avg(BaseUsersRecord::login))
                .where(
                        r -> r.login().contains("toto"),
                        AND,
                        r -> r.active().isFalse()
                );


    }

}
