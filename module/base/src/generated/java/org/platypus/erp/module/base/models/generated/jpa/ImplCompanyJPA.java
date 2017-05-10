package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.api.query.QueryPath;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.LongFieldImpl;

@Table(
    name = ImplCompanyJPA.MODEL_NAME
)
@Entity
public class ImplCompanyJPA extends BaseCompanyRecordImpl {
  public static final String MODEL_NAME = "company";

  @Column(
      name = "\"id\"",
      nullable = true,
      insertable = true,
      updatable = true
  )
  private long id = 0;

  public ImplCompanyJPA(Supplier<QueryPath> getPath) {
    super(getPath);
  }

  public ImplCompanyJPA() {
    super();
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
