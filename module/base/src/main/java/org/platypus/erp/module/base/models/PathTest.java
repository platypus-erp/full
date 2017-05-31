package org.platypus.erp.module.base.models;

import base.BaseRecordPool;
import base.BaseRecordPool2;
import org.platypus.api.service.PlatypusService;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord2;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

    @Inject
    BaseRecordPool baseRecordPool;

    @Inject
    BaseRecordPool2 baseRecordPool2;

    @Path("test")
    @GET
    public void test() {
//        List<BaseUsersRecord> list = search(q ->
//                q.get(
//                        BaseUsersRecord::login,
//                        BaseUsersRecord::password
//                ).filter(
//                        r -> r.active().isTrue(),
//                        AND,
//                        NewDomain(
//                                r -> r.login().contains("admin"),
//                                OR,
//                                r -> r.login().startWith("alexis")
//                        )
//                ).sortAsc(BaseUsersRecord::login)
//        );

        BaseUsersRecord r = baseRecordPool.user().newRecord();
        BaseUsersRecord2 r2 = baseRecordPool2.user().newRecord();
        r = baseRecordPool.user().test(r, rec -> rec);


        r = baseRecordPool2.user().test(r2, rec -> rec);



    }


}
