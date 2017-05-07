package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

public class BaseUsersRecordImpl extends RecordImpl<BaseUsersRecord, ImplUsersJPA> implements BaseUsersRecord {
  public BaseUsersRecordImpl(Supplier<ImplUsersJPA> getter, Consumer<ImplUsersJPA> setter) {
    super(getter, setter);
  }

  @Override
  public BinaryField signature() {
    return get().signature();
  }

  @Override
  public void signature(final BinaryField signature) {
    get().signature(signature);
  }

  @Override
  public BooleanField active() {
    return get().active();
  }

  @Override
  public void active(final BooleanField active) {
    get().active(active);
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
  public BaseCompanyRecord company() {
    return get().company();
  }

  @Override
  public void company(final BaseCompanyRecord company) {
    get().company(company);
  }

  @Override
  public BasePartnerRecord partner() {
    return get().partner();
  }

  @Override
  public void partner(final BasePartnerRecord partner) {
    get().partner(partner);
  }

  @Override
  public BaseCompanyRecord companies() {
    return get().companies();
  }

  @Override
  public void companies(final BaseCompanyRecord companies) {
    get().companies(companies);
  }

  @Override
  public BaseGroupRecord action() {
    return get().action();
  }

  @Override
  public void action(final BaseGroupRecord action) {
    get().action(action);
  }

  @Override
  public BaseGroupRecord groups() {
    return get().groups();
  }

  @Override
  public void groups(final BaseGroupRecord groups) {
    get().groups(groups);
  }
}
