package org.platypus.erp.module.base;

import org.platypus.api.service.PlatypusService;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import java.util.List;

import static org.platypus.api.query.Domain.DomainCombinator.AND;
import static org.platypus.api.query.Domain.DomainCombinator.OR;
import static org.platypus.api.query.Domain.NewDomain;

/**
 * @author chmuchme
 * @since 0.1
 * on 23/05/17.
 */
@Path("test")
@Stateless
public class PathTest extends PlatypusService<BaseUsersRecord> {

    public PathTest() {
        super(BaseUsersRecord.class);
    }

    @Path("test")
    @GET
    public void test() {
        List<BaseUsersRecord> list = search(q ->
                q.get(
                        BaseUsersRecord::login,
                        BaseUsersRecord::password
                ).filter(
                        r -> r.active().isTrue(),
                        AND,
                        NewDomain(
                                r -> r.login().contains("admin").not().orNull(),
                                OR,
                                r -> r.login().startWith("alexis")
                        )
                ).sortAsc(BaseUsersRecord::login)
        );
    }
}
