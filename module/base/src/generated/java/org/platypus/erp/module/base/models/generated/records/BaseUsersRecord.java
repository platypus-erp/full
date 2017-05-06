package org.platypus.erp.module.base.models.generated.records;

import org.platypus.api.Record;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;

public interface BaseUsersRecord extends Record {
  BinaryField signature();

  void signature(BinaryField signature);

  BooleanField share();

  BooleanField active();

  void share(BooleanField share);

  void active(BooleanField active);

  StringField password();

  StringField login();

  StringField new_password();

  void password(StringField password);

  void login(StringField login);

  void new_password(StringField new_password);

  BaseGroupRecordCollection action();

  BaseGroupRecordCollection groups();

  BaseCompanyRecordCollection companies();

  void action(BaseGroupRecordCollection action);

  void groups(BaseGroupRecordCollection groups);

  void companies(BaseCompanyRecordCollection companies);

  BaseCompanyRecord company();

  void company(BaseCompanyRecord company);

  BasePartnerRecord partner();

  void partner(BasePartnerRecord partner);
}
