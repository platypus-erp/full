package base;

import org.platypus.api.Pool;
import org.platypus.api.Record;
import org.platypus.erp.module.base.models.generated.jpa.ImplCompanyJPA;
import org.platypus.erp.module.base.models.generated.jpa.ImplGroupJPA;
import org.platypus.erp.module.base.models.generated.jpa.ImplPartnerJPA;
import org.platypus.erp.module.base.models.generated.jpa.ImplUsersJPA;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import javax.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author chmuchme
 * @since 0.1
 * on 23/05/17.
 */
public class BaseRecordPoolImpl implements BaseRecordPool, Pool{
    Map<Class<?>, Supplier<?>> suppliers = new HashMap<>();



    @PostConstruct
    public void postCreate(){
        suppliers.put(BasePartnerRecord.class, ImplPartnerJPA::new);
        suppliers.put(BaseUsersRecord.class, ImplUsersJPA::new);
        suppliers.put(BaseCompanyRecord.class, ImplCompanyJPA::new);
        suppliers.put(BaseGroupRecord.class, ImplGroupJPA::new);
    }



    @Override
    public BasePartnerRecord getPartner() {
        return new ImplPartnerJPA();
    }

    @Override
    public BaseUsersRecord getUsers() {
        return new ImplUsersJPA();
    }

    @Override
    public BaseCompanyRecord getCompany() {
        return new ImplCompanyJPA();
    }

    @Override
    public BaseGroupRecord getGroup() {
        return new ImplGroupJPA();
    }

    @Override
    public <T extends Record> T get(Class<T> aRecordClass) {
        return (T) suppliers.get(aRecordClass).get();
    }
}
