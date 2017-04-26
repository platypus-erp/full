package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.BinaryFieldImpl;
import org.platypus.api.fields.impl.BooleanFieldImpl;
import org.platypus.api.fields.impl.StringFieldImpl;
import org.platypus.erp.module.base.models.generated.records.UserRecord;

@Table(
    name = ImplUserJPA.MODEL_NAME
)
@Entity
public class ImplUserJPA implements UserRecord {
  public static final String MODEL_NAME = "user";

  @Lob
  @Basic(
      fetch = FetchType.EAGER
  )
  @Column(
      name = "\"signature\"",
      nullable = true,
      insertable = true,
      updatable = true
  )
  private byte[] signature;

  private final BinaryField signatureField;

  @Column(
      name = "\"share\"",
      nullable = false,
      insertable = true,
      updatable = true
  )
  private boolean share;

  private final BooleanField shareField;

  @Column(
      name = "\"password\"",
      insertable = true,
      updatable = true
  )
  private String password;

  private final StringField passwordField;

  @Column(
      name = "\"new_password\"",
      insertable = true,
      updatable = true
  )
  private String new_password;

  private final StringField new_passwordField;

  @Size(
      max = 64
  )
  @Column(
      name = "\"login\"",
      insertable = true,
      updatable = true
  )
  private String login;

  private final StringField loginField;

  public ImplUserJPA() {
    signatureField = new BinaryFieldImpl<>(this, ImplUserJPA::getSignature, ImplUserJPA::setSignature);
    shareField = new BooleanFieldImpl<>(this, ImplUserJPA::getShare, ImplUserJPA::setShare);
    passwordField = new StringFieldImpl<>(this, ImplUserJPA::getPassword, ImplUserJPA::setPassword);
    new_passwordField = new StringFieldImpl<>(this, ImplUserJPA::getNew_password, ImplUserJPA::setNew_password);
    loginField = new StringFieldImpl<>(this, ImplUserJPA::getLogin, ImplUserJPA::setLogin);
    partnerField = new PartnerRecordImpl<>(this,ImplPartnerRecordJPA.class, ImplUserJPA::getPartner, ImplUserJPA::setPartner)company_idField = new CompanyRecordImpl<>(this,ImplCompanyRecordJPA.class, ImplUserJPA::getCompany_id, ImplUserJPA::setCompany_id)}

  public byte[] getSignature() {
    return this.signature;
  }

  public void setSignature(final byte[] signature) {
    this.signature = signature;
  }

  @Override
  public void signature(final BinaryField signatureField) {
    this.setSignature(signatureField.get());
  }

  @Override
  public BinaryField signature() {
    return signatureField;
  }

  public boolean getShare() {
    return this.share;
  }

  public void setShare(final boolean share) {
    this.share = share;
  }

  @Override
  public void share(final BooleanField shareField) {
    this.setShare(shareField.get());
  }

  @Override
  public BooleanField share() {
    return shareField;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  @Override
  public void password(final StringField passwordField) {
    this.setPassword(passwordField.get());
  }

  @Override
  public StringField password() {
    return passwordField;
  }

  public String getNew_password() {
    return this.new_password;
  }

  public void setNew_password(final String new_password) {
    this.new_password = new_password;
  }

  @Override
  public void new_password(final StringField new_passwordField) {
    this.setNew_password(new_passwordField.get());
  }

  @Override
  public StringField new_password() {
    return new_passwordField;
  }

  public String getLogin() {
    return this.login;
  }

  public void setLogin(final String login) {
    this.login = login;
  }

  @Override
  public void login(final StringField loginField) {
    this.setLogin(loginField.get());
  }

  @Override
  public StringField login() {
    return loginField;
  }
}
