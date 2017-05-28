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
import org.platypus.api.query.tmp.QueryPathImpl;
import org.platypus.erp.module.base.models.generated.records.BaseGroupRecord;

@Table(
    name = ImplGroupJPA.MODEL_NAME
)
@Entity
public class ImplGroupJPA implements BaseGroupRecord {
  public static final String MODEL_NAME = "groups";
  @Transient
  private QueryPathImpl path = QueryPathImpl.basic(MODEL_NAME, "id");
  @Id
  @Column(
      name = "\"id\"",
      nullable = true,
      insertable = true,
      updatable = true
  )
  private long id = 0;

  @Override
  public QueryPathImpl getPath() {
    return this.path;}

  @Override
  public void setPath(QueryPathImpl path) {
    this.path = path;}

  @Override
  public QueryPathImpl resolve(QueryPathImpl path) {
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
