package org.platypus.erp.module.base.models;

import base.BaseRecordPool;
import org.platypus.api.Record;
import org.platypus.api.query.projection.ProjectionField;
import org.platypus.api.query.tmp.QueryPathImpl;
import org.platypus.erp.manager.impl.SimpleQueryImpl;
import org.platypus.api.query.projection.QueryAgregator;
import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import java.util.ArrayList;
import java.util.List;

import static org.platypus.api.query.domain.DomainCombinator.AND;


/**
 * Created by apasquier on 04/05/17.
 */
public class UserBusiness {


    public void onChangeLogin(BaseUsersRecord record) {
        if (record.login().match("")) {

        }


        org.platypus.erp.module.base.models.QueryBuilder.Predicate query = org.platypus.erp.module.base.models.QueryBuilder.eq(record.login(), "sdlfmsd");
        record.partner().id().getPath();
    }

    static BaseRecordPool pool;


    public static void main(String[] args) {


//        ImplUsersJPA record = new ImplUsersJPA();
////        System.out.println(record.getPath());
////        System.out.println(record.partner().getPath());
//        BasePartnerRecord rp = record.partner();
//        System.out.println(record.getPath());
//        System.out.println(rp.getPath());
//        System.out.println(rp.id().getPath());
//        System.out.println(record.share().getPath());
//
//
//        SimpleQueryImpl.Predicate pre = SimpleQueryImpl.eq(record.active(), true);
//        System.out.println(pre);


        SimpleQueryImpl<BaseUsersRecord> loginActive = SimpleQueryImpl.from(BaseUsersRecord.class)
                .get(
                        BaseUsersRecord::partner,
                        BaseUsersRecord::login,
                        r -> r.partner().id()
                )
                .get(new QueryAgregator<BaseUsersRecord>().avg(BaseUsersRecord::login))
                .filter(
                        r -> r.login().contains("toto"),
                        AND,
                        r -> r.active().isFalse()
                ).or().filter(
                        r -> r.new_password().isNotNull()
                );
        test(loginActive, new ImplUsersJPA());


    }

    static <T extends Record> void test(SimpleQueryImpl<T> searchBuilder, T instance){


        List<ProjectionField<T>> projection = searchBuilder.getProjection();
        String mainTableName = instance.getName();

        List<String> tableJoin = new ArrayList<>();
        for (ProjectionField<T> pro : projection){
            QueryPathImpl path = pro.getField().apply(instance).getPath();
            System.out.println(path.getTablePath());
            System.out.println(path);



            System.out.println(path.tableName);
            System.out.println(path.columnName);
            System.out.println(path.isRelation);
        }
    }

}
