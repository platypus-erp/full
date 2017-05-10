package org.platypus.erp.module.base.models;

import org.platypus.api.fields.StringField;
import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import java.util.List;
import java.util.stream.Collectors;

import static org.platypus.api.query.SearchBuilder.and;
import static org.platypus.api.query.SearchBuilder.from;
import static org.platypus.api.query.SearchBuilder.or;

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


    public static void main(String[] args) {
        ImplUsersJPA record = new ImplUsersJPA();
//        System.out.println(record.getPath());
//        System.out.println(record.partner().getPath());
        BasePartnerRecord r = record.partner();
        System.out.println(record.getPath());
        System.out.println(r.getPath());
        System.out.println(r.id().getPath());
        System.out.println(record.share().getPath());


        QueryBuilder.Predicate pre = QueryBuilder.eq(record.active(), true);
        System.out.println(pre);


        List<String> loginActive = from(BaseUsersRecord.class)
                .filter(
                        or(record.active().isTrue(),
                                and(
                                        record.active().isFalse(),
                                        record.active().isUnSet()
                                )
                        )
                ).filter(record.active().isUnSetOrTrue())
                .sortAsc(record.id())
                .stream()
                .map(BaseUsersRecord::login)
                .map(StringField::get)
                .collect(Collectors.toList());
    }
}
