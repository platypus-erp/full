package org.platypus.erp.module.base.models.generated.records;

import java.lang.Override;
import java.lang.String;
import org.platypus.api.Record;
import org.platypus.api.annotations.record.RecordOf;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;

@RecordOf(
      modelPkg = "org.platypus.erp.module.base.models",
      modelClassName = "Users",
      modelName = "users"
)
public interface BaseUsersRecord extends Record {
   @Override
   default String getTableName() {
      return "users";
   }

   BinaryField signature();

   void signature(BinaryField signature);

   BooleanField active();

   BooleanField share();

   void active(BooleanField active);

   void share(BooleanField share);

   StringField new_password();

   StringField login();

   StringField password();

   void new_password(StringField new_password);

   void login(StringField login);

   void password(StringField password);

   BaseCompanyRecordCollection companies();

   BaseGroupRecordCollection action();

   BaseGroupRecordCollection groups();

   void companies(BaseCompanyRecordCollection companies);

   void action(BaseGroupRecordCollection action);

   void groups(BaseGroupRecordCollection groups);

   BaseCompanyRecord company();

   void company(BaseCompanyRecord company);

   BasePartnerRecord partner();

   void partner(BasePartnerRecord partner);
}
