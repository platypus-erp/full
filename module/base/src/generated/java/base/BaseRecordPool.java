package base;

import org.platypus.api.ModuleMeta;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

public interface BaseRecordPool extends ModuleMeta {
   BasePartnerRecord getPartner();

   BaseUsersRecord getUsers();

   BaseCompanyRecord getCompany();

   BaseGroupRecord getGroup();
}
