package org.platypus.erp.module.base.generated.models.generated.jpa;

import java.lang.Class;
import java.lang.Override;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.generated.models.generated.records.CompanyRecord;
import org.platypus.erp.module.base.generated.models.generated.records.PartnerRecord;
import org.platypus.erp.module.base.generated.models.generated.records.UserRecord;

public class UserRecordImpl<T extends Record> extends RecordImpl<T, UserRecord, ImplUserJPA> implements UserRecord {
  public UserRecordImpl(T instance, Class<ImplUserJPA> targetRecordImpl,
      Function<T, ImplUserJPA> getter, BiConsumer<T, ImplUserJPA> setter) {
    super(instance, targetRecordImpl, getter, setter);}

  @Override
  public BinaryField signature() {
    return get().signature();
  }

  @Override
  public void signature(final BinaryField signature) {
    get().signature(signature);
  }

  @Override
  public BooleanField share() {
    return get().share();
  }

  @Override
  public void share(final BooleanField share) {
    get().share(share);
  }

  @Override
  public StringField password() {
    return get().password();
  }

  @Override
  public void password(final StringField password) {
    get().password(password);
  }

  @Override
  public StringField new_password() {
    return get().new_password();
  }

  @Override
  public void new_password(final StringField new_password) {
    get().new_password(new_password);
  }

  @Override
  public StringField login() {
    return get().login();
  }

  @Override
  public void login(final StringField login) {
    get().login(login);
  }

  @Override
  public PartnerRecord partner() {
    return get().partner();
  }

  @Override
  public void partner(final PartnerRecord partner) {
    get().partner(partner);
  }

  @Override
  public CompanyRecord company_id() {
    return get().company_id();
  }

  @Override
  public void company_id(final CompanyRecord company_id) {
    get().company_id(company_id);
  }
}
