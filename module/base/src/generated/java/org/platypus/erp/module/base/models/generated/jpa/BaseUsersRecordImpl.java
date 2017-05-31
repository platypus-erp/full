package org.platypus.erp.module.base.models.generated.jpa;

import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseUsersRecordImpl extends RecordImpl<BaseUsersRecord, ImplUsersJPA> implements BaseUsersRecord {
  public BaseUsersRecordImpl(String table, String name, Supplier<QueryPath> getPath,
      Supplier<ImplUsersJPA> getter, Consumer<ImplUsersJPA> setter) {
    super(table, name, getPath, getter, setter, ImplUsersJPA::new);
  }

    @Override
  public BinaryField signature() {
    return getOrDefault().signature();
  }

  @Override
  public void signature(final BinaryField signature) {
    getOrDefault().signature(signature);
  }

  @Override
  public BooleanField active() {
    return getOrDefault().active();
  }

  @Override
  public void active(final BooleanField active) {
    getOrDefault().active(active);
  }

  @Override
  public BooleanField share() {
    return getOrDefault().share();
  }

  @Override
  public void share(final BooleanField share) {
    getOrDefault().share(share);
  }

  @Override
  public LongField id() {
    return getOrDefault().id();
  }

  @Override
  public StringField password() {
    return getOrDefault().password();
  }

  @Override
  public void password(final StringField password) {
    getOrDefault().password(password);
  }

  @Override
  public StringField new_password() {
    return getOrDefault().new_password();
  }

  @Override
  public void new_password(final StringField new_password) {
    getOrDefault().new_password(new_password);
  }

  @Override
  public StringField login() {
    return getOrDefault().login();
  }

  @Override
  public void login(final StringField login) {
    getOrDefault().login(login);
  }

  @Override
  public BaseCompanyRecord company() {
    return getOrDefault().company();
  }

  @Override
  public void company(final BaseCompanyRecord company) {
    getOrDefault().company(company);
  }

  @Override
  public BasePartnerRecord partner() {
    return getOrDefault().partner();
  }

  @Override
  public void partner(final BasePartnerRecord partner) {
    getOrDefault().partner(partner);
  }

  @Override
  public BaseCompanyRecordCollection companies() {
    return getOrDefault().companies();
  }

  @Override
  public void companies(final BaseCompanyRecordCollection companies) {
    getOrDefault().companies(companies);
  }

  @Override
  public BaseGroupRecordCollection action() {
    return getOrDefault().action();
  }

  @Override
  public void action(final BaseGroupRecordCollection action) {
    getOrDefault().action(action);
  }

  @Override
  public BaseGroupRecordCollection groups() {
    return getOrDefault().groups();
  }

  @Override
  public void groups(final BaseGroupRecordCollection groups) {
    getOrDefault().groups(groups);
  }
}
