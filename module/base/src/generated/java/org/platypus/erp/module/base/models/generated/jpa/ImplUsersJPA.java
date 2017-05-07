package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.BinaryFieldImpl;
import org.platypus.api.fields.impl.BooleanFieldImpl;
import org.platypus.api.fields.impl.StringFieldImpl;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecordCollection;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;
import org.platypus.erp.module.base.models.generated.records.BaseUsersRecord;

@Table(
    name = ImplUsersJPA.MODEL_NAME
)
@Entity
public class ImplUsersJPA implements BaseUsersRecord {
  public static final String MODEL_NAME = "users";

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
      name = "\"active\"",
      nullable = false,
      insertable = true,
      updatable = true
  )
  private boolean active;

  @Transient
  private final BooleanField activeField;

  @Column(
      name = "\"share\"",
      nullable = false,
      insertable = true,
      updatable = true
  )
  private boolean share;

  @Transient
  private final BooleanField shareField;

  @Size(
      max = 64
  )
  @Column(
      name = "\"password\"",
      insertable = true,
      updatable = true
  )
  private String password;

  @Transient
  private final StringField passwordField;

  @Size(
      max = 64
  )
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

  @ManyToOne
  @JoinColumn(
      name = "\"company\"",
      updatable = true
  )
  private ImplCompanyJPA company;

  @Transient
  private final BaseCompanyRecord companyField;

  @OneToOne(
      optional = false
  )
  @JoinColumn(
      name = "\"partner\"",
      updatable = true
  )
  private ImplPartnerJPA partner;

  @Transient
  private final BasePartnerRecord partnerField;

  @ManyToMany
  @JoinTable
  @JoinColumn(
      name = "\"companies\"",
      updatable = true
  )
  private List<ImplCompanyJPA> companies;

  @Transient
  private final BaseCompanyRecordCollection companiesField;

  @ManyToMany
  @JoinTable
  @JoinColumn(
      name = "\"action\"",
      updatable = true
  )
  private List<ImplGroupJPA> action;

  @Transient
  private final BaseGroupRecordCollection actionField;

  @ManyToMany
  @JoinTable
  @JoinColumn(
      name = "\"groups\"",
      updatable = true
  )
  private List<ImplGroupJPA> groups;

  @Transient
  private final BaseGroupRecordCollection groupsField;

  public ImplUsersJPA() {
    signatureField = new BinaryFieldImpl(this::getSignature, this::setSignature);
    activeField = new BooleanFieldImpl(this::getActive, this::setActive);
    shareField = new BooleanFieldImpl(this::getShare, this::setShare);
    passwordField = new StringFieldImpl(this::getPassword, this::setPassword);
    new_passwordField = new StringFieldImpl(this::getNew_password, this::setNew_password);
    loginField = new StringFieldImpl(this::getLogin, this::setLogin);
    companyField = new BaseCompanyRecordImpl(this::getCompany, this::setCompany);
    partnerField = new BasePartnerRecordImpl(this::getPartner, this::setPartner);
    companiesField = new BaseCompanyRecordCollectionImpl(this::getCompanies, this::setCompanies);
    actionField = new BaseGroupRecordCollectionImpl(this::getAction, this::setAction);
    groupsField = new BaseGroupRecordCollectionImpl(this::getGroups, this::setGroups);
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

  public boolean getActive() {
    return this.active;
  }

  public void setActive(final boolean active) {
    this.active = active;
  }

  @Override
  public void active(final BooleanField activeField) {
    this.setActive(activeField.get());
  }

  @Override
  public BooleanField active() {
    return activeField;
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

  public ImplCompanyJPA getCompany() {
    return this.company;
  }

  public void setCompany(final ImplCompanyJPA company) {
    this.company = company;
  }

  @Override
  public void company(final BaseCompanyRecord companyField) {
    this.setCompany(companyField.unWrap(ImplCompanyJPA.class));
  }

  @Override
  public BaseCompanyRecord company() {
    return companyField;
  }

  public ImplPartnerJPA getPartner() {
    return this.partner;
  }

  public void setPartner(final ImplPartnerJPA partner) {
    this.partner = partner;
  }

  @Override
  public void partner(final BasePartnerRecord partnerField) {
    this.setPartner(partnerField.unWrap(ImplPartnerJPA.class));
  }

  @Override
  public BasePartnerRecord partner() {
    return partnerField;
  }

  public List<ImplCompanyJPA> getCompanies() {
    return this.companies;
  }

  public void setCompanies(final List<ImplCompanyJPA> companies) {
    this.companies = companies;
  }

  @Override
  public void companies(final BaseCompanyRecordCollection companiesField) {
    this.setCompanies(companiesField.unWrapAsList(ImplCompanyJPA.class));
  }

  @Override
  public BaseCompanyRecordCollection companies() {
    return companiesField;
  }

  public List<ImplGroupJPA> getAction() {
    return this.action;
  }

  public void setAction(final List<ImplGroupJPA> action) {
    this.action = action;
  }

  @Override
  public void action(final BaseGroupRecordCollection actionField) {
    this.setAction(actionField.unWrapAsList(ImplGroupJPA.class));
  }

  @Override
  public BaseGroupRecordCollection action() {
    return actionField;
  }

  public List<ImplGroupJPA> getGroups() {
    return this.groups;
  }

  public void setGroups(final List<ImplGroupJPA> groups) {
    this.groups = groups;
  }

  @Override
  public void groups(final BaseGroupRecordCollection groupsField) {
    this.setGroups(groupsField.unWrapAsList(ImplGroupJPA.class));
  }

  @Override
  public BaseGroupRecordCollection groups() {
    return groupsField;
  }
}
