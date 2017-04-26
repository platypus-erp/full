package org.platypus.erp.module.base.models.generated.records;

import org.platypus.api.Record;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;

public interface UserRecord extends Record {
  BinaryField signature();

  void signature(BinaryField signature);

  BooleanField share();

  void share(BooleanField share);

  StringField password();

  StringField new_password();

  StringField login();

  void password(StringField password);

  void new_password(StringField new_password);

  void login(StringField login);

  PartnerRecord partner();

  void partner(PartnerRecord partner);

  CompanyRecord company_id();

  void company_id(CompanyRecord company_id);
}
