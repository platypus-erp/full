package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.BinaryFieldImpl;
import org.platypus.api.fields.impl.BooleanFieldImpl;
import org.platypus.api.fields.impl.LongFieldImpl;
import org.platypus.api.fields.impl.StringFieldImpl;
import org.platypus.api.query.QueryPath;
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

  @Transient
  private QueryPath path = QueryPath.basic(MODEL_NAME, "id");

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

  @Column(
      name = "\"active\"",
      nullable = false,
      insertable = true,
      updatable = true
  )
  private boolean active;

  @Column(
      name = "\"share\"",
      nullable = false,
      insertable = true,
      updatable = true
  )
  private boolean share;

  @Id
  @Column(
      name = "\"id\"",
      nullable = true,
      insertable = true,
      updatable = true
  )
  private long id = 0;

  @Size(
      max = 64
  )
  @Column(
      name = "\"password\"",
      insertable = true,
      updatable = true
  )
  private String password;

  @Size(
      max = 64
  )
  @Column(
      name = "\"new_password\"",
      insertable = true,
      updatable = true
  )
  private String new_password;

  @Size(
      max = 64
  )
  @Column(
      name = "\"login\"",
      insertable = true,
      updatable = true
  )
  private String login;

  @ManyToOne
  @JoinColumn(
      name = "\"company\"",
      updatable = true
  )
  private ImplCompanyJPA company;

  @OneToOne(
      optional = false
  )
  @JoinColumn(
      name = "\"partner\"",
      updatable = true
  )
  private ImplPartnerJPA partner;

  @ManyToMany
  @JoinTable
  @JoinColumn(
      name = "\"companies\"",
      updatable = true
  )
  private List<ImplCompanyJPA> companies;

  @ManyToMany
  @JoinTable
  @JoinColumn(
      name = "\"action\"",
      updatable = true
  )
  private List<ImplGroupJPA> action;

  @ManyToMany
  @JoinTable
  @JoinColumn(
      name = "\"groups\"",
      updatable = true
  )
  private List<ImplGroupJPA> groups;

  @Override
  public QueryPath getPath() {
    return this.path;}

  @Override
  public void setPath(QueryPath path) {
    this.path = path;}

  @Override
  public QueryPath resolve(QueryPath path) {
    return this.path.resolve(path);
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
    return new BinaryFieldImpl(MODEL_NAME, "signature", this::getPath, this::getSignature, this::setSignature);
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
    return new BooleanFieldImpl(MODEL_NAME, "active", this::getPath, this::getActive, this::setActive);
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
    return new BooleanFieldImpl(MODEL_NAME, "share", this::getPath, this::getShare, this::setShare);
  }

  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  @Override
  public LongField id() {
    return new LongFieldImpl(MODEL_NAME, "id", this::getPath, this::getId, this::setId);
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
    return new StringFieldImpl(MODEL_NAME, "password", this::getPath, this::getPassword, this::setPassword);
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
    return new StringFieldImpl(MODEL_NAME, "new_password", this::getPath, this::getNew_password, this::setNew_password);
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
    return new StringFieldImpl(MODEL_NAME, "login", this::getPath, this::getLogin, this::setLogin);
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
    return new BaseCompanyRecordImpl(MODEL_NAME, "company", this::getPath, this::getCompany, this::setCompany);
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
    return new BasePartnerRecordImpl(MODEL_NAME, "partner", this::getPath, this::getPartner, this::setPartner);
  }

  public List<ImplCompanyJPA> getCompanies() {
    return this.companies;
  }

  public void setCompanies(final List<ImplCompanyJPA> companies) {
    this.companies = companies;
  }

  @Override
  public void companies(final BaseCompanyRecordCollection companiesField) {
    this.setCompanies(companiesField.asList(ImplCompanyJPA.class));
  }

  @Override
  public BaseCompanyRecordCollection companies() {
    return new BaseCompanyRecordCollectionImpl(MODEL_NAME, "companies",this::getPath, this::getCompanies, this::setCompanies);
  }

  public List<ImplGroupJPA> getAction() {
    return this.action;
  }

  public void setAction(final List<ImplGroupJPA> action) {
    this.action = action;
  }

  @Override
  public void action(final BaseGroupRecordCollection actionField) {
    this.setAction(actionField.asList(ImplGroupJPA.class));
  }

  @Override
  public BaseGroupRecordCollection action() {
    return new BaseGroupRecordCollectionImpl(MODEL_NAME, "action",this::getPath, this::getAction, this::setAction);
  }

  public List<ImplGroupJPA> getGroups() {
    return this.groups;
  }

  public void setGroups(final List<ImplGroupJPA> groups) {
    this.groups = groups;
  }

  @Override
  public void groups(final BaseGroupRecordCollection groupsField) {
    this.setGroups(groupsField.asList(ImplGroupJPA.class));
  }

  @Override
  public BaseGroupRecordCollection groups() {
    return new BaseGroupRecordCollectionImpl(MODEL_NAME, "groups",this::getPath, this::getGroups, this::setGroups);
  }
}
