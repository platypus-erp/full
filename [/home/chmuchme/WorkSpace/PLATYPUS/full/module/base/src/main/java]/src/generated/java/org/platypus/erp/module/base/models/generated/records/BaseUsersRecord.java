package org.platypus.erp.module.base.models.generated.records;

import org.platypus.api.Record;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;

public interface BaseUsersRecord extends Record {
  BinaryField signature();

  void signature(BinaryField signature);

  BooleanField active();

  BooleanField share();

  void active(BooleanField active);

  void share(BooleanField share);

  StringField login();

  StringField password();

  StringField new_password();

  void login(StringField login);

  void password(StringField password);

  void new_password(StringField new_password);

  BaseGroupRecordCollection action();

  BaseCompanyRecordCollection companies();

  BaseGroupRecordCollection groups();

  void action(BaseGroupRecordCollection action);

  void companies(BaseCompanyRecordCollection companies);

  void groups(BaseGroupRecordCollection groups);

  BaseCompanyRecord company();

  void company(BaseCompanyRecord company);

  BasePartnerRecord partner();

  void partner(BasePartnerRecord partner);
}
