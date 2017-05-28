package org.platypus.erp.module.base.models;

import org.platypus.api.query.SimpleQuery;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import static org.platypus.api.query.domain.DomainBuilder.NewDomain;
import static org.platypus.api.query.domain.DomainCombinator.AND;
import static org.platypus.api.query.domain.DomainCombinator.OR;

/**
 * @author chmuchme
 * @since 0.1
 * on 23/05/17.
 */
@Path("test")
@Stateless
public class PathTest {


    @Inject
    SimpleQuery<BaseUsersRecord> queryUser;


    @Path("test")
    @GET
    public void test() {
        queryUser.get(
                BaseUsersRecord::login,
                BaseUsersRecord::password
        ).filter(
                r -> r.active().isTrue(),
                AND,
                NewDomain(
                        r -> r.login().contains("admin"),
                        OR,
                        r -> r.login().startWith("alexis")
                )
        ).limit(2)
                .page(2, 10).distinct(true);
    }


}
