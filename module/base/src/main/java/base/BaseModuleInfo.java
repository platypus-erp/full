package base;

import org.platypus.api.annotations.ModuleInfo;
import org.platypus.builder.core.AbstractModule;
import org.platypus.erp.module.base.models.Company;
import org.platypus.erp.module.base.models.Group;
import org.platypus.erp.module.base.models.Partner;
import org.platypus.erp.module.base.models.Users;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecordCollection;

@ModuleInfo(
        name = "base",
        moduleVersion = "1"
)
public class BaseModuleInfo extends AbstractModule {
    public BaseModuleInfo() {
        super("Sample Module with all platypus and community depends");
        addModel(Users.class);
        addModel(Group.class);
        addModel(Company.class);
        addModel(Partner.class);
        addRecord(BaseGroupRecord.class);
        addRecord(BaseUsersRecord.class);
        addRecord(BaseCompanyRecord.class);
        addRecord(BasePartnerRecord.class);
        addRecordCollection(BaseCompanyRecordCollection.class);
        addRecordCollection(BasePartnerRecordCollection.class);
        addRecordCollection(BaseGroupRecordCollection.class);
        addRecordCollection(BaseUsersRecordCollection.class);
        addView("views/partner-list.xml");
    }
}
