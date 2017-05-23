package org.platypus.erp.module.base.models;

import org.platypus.api.query.SearchBuilder;
import org.platypus.api.query.SearchExecutor;
import org.platypus.api.query.predicate.impl.PredicateBuilder;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static org.platypus.api.query.PredicateCombinator.AND;

/**
 * @author chmuchme
 * @since 0.1
 * on 23/05/17.
 */
@Path("test")
public class PathTest {


    @Inject
    SearchExecutor<BaseUsersRecord> baseUsersRecordSearchExecutor;


    @Path("test")
    @GET
    public void test(){
        System.out.println("Test");
        SearchBuilder<BaseUsersRecord> loginActive = SearchBuilder.from(BaseUsersRecord.class)
                .get(
                        BaseUsersRecord::partner,
                        BaseUsersRecord::login,
                        r -> r.partner().id()
                )
                .get(new PredicateBuilder<BaseUsersRecord>().avg(BaseUsersRecord::login))
                .filter(
                        r -> r.login().contains("toto"),
                        AND,
                        r -> r.active().isFalse()
                ).or().filter(
                        r -> r.new_password().isNotNull()
                );
        baseUsersRecordSearchExecutor.count(loginActive);
    }
}
