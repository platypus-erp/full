package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.LongFieldImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BaseCompanyRecord;

@Table(
    name = ImplCompanyJPA.MODEL_NAME
)
@Entity
public class ImplCompanyJPA implements BaseCompanyRecord {
  public static final String MODEL_NAME = "company";
  @Transient
  private QueryPath path = QueryPath.basic(MODEL_NAME, "id");

  @Id
  @Column(
      name = "\"id\"",
      nullable = true,
      insertable = true,
      updatable = true
  )
  private long id = 0;

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
}
