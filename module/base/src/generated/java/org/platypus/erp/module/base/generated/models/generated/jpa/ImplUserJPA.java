package org.platypus.erp.module.base.generated.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.BinaryFieldImpl;
import org.platypus.api.fields.impl.BooleanFieldImpl;
import org.platypus.api.fields.impl.StringFieldImpl;
import org.platypus.erp.module.base.generated.models.generated.records.CompanyRecord;
import org.platypus.erp.module.base.generated.models.generated.records.PartnerRecord;
import org.platypus.erp.module.base.generated.models.generated.records.UserRecord;

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

  @Transient
  private final BinaryField signatureField;

  @Column(
      name = "\"share\"",
      nullable = false,
      insertable = true,
      updatable = true
  )
  private boolean share;

  @Transient
  private final BooleanField shareField;

  @Column(
      name = "\"password\"",
      insertable = true,
      updatable = true
  )
  private String password;

  @Transient
  private final StringField passwordField;

  @Column(
      name = "\"new_password\"",
      insertable = true,
      updatable = true
  )
  private String new_password;

  @Transient
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

  @Transient
  private final StringField loginField;

  @Column(
      name = "\"partner\""
  )
  @ManyToOne
  private ImplPartnerJPA partner;

  @Transient
  private final PartnerRecord partnerField;

  @Column(
      name = "\"company_id\""
  )
  @ManyToOne
  private ImplCompanyJPA company_id;

  @Transient
  private final CompanyRecord company_idField;

  public ImplUserJPA() {
    signatureField = new BinaryFieldImpl<>(this, ImplUserJPA::getSignature, ImplUserJPA::setSignature);
    shareField = new BooleanFieldImpl<>(this, ImplUserJPA::getShare, ImplUserJPA::setShare);
    passwordField = new StringFieldImpl<>(this, ImplUserJPA::getPassword, ImplUserJPA::setPassword);
    new_passwordField = new StringFieldImpl<>(this, ImplUserJPA::getNew_password, ImplUserJPA::setNew_password);
    loginField = new StringFieldImpl<>(this, ImplUserJPA::getLogin, ImplUserJPA::setLogin);
    partnerField = new PartnerRecordImpl<>(this,ImplPartnerJPA.class, ImplUserJPA::getPartner, ImplUserJPA::setPartner);
    company_idField = new CompanyRecordImpl<>(this,ImplCompanyJPA.class, ImplUserJPA::getCompany_id, ImplUserJPA::setCompany_id);
  }

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

  public ImplPartnerJPA getPartner() {
    return this.partner;
  }

  public void setPartner(final ImplPartnerJPA partner) {
    this.partner = partner;
  }

  @Override
  public void partner(final PartnerRecord partnerField) {
    this.setPartner(partnerField.unWrap(ImplPartnerJPA.class));
  }

  @Override
  public PartnerRecord partner() {
    return partnerField;
  }

  public ImplCompanyJPA getCompany_id() {
    return this.company_id;
  }

  public void setCompany_id(final ImplCompanyJPA company_id) {
    this.company_id = company_id;
  }

  @Override
  public void company_id(final CompanyRecord company_idField) {
    this.setCompany_id(company_idField.unWrap(ImplCompanyJPA.class));
  }

  @Override
  public CompanyRecord company_id() {
    return company_idField;
  }
}
