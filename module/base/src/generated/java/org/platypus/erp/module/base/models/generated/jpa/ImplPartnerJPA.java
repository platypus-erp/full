package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.api.QueryPath;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.LongFieldImpl;

@Table(
    name = ImplPartnerJPA.MODEL_NAME
)
@Entity
public class ImplPartnerJPA extends BasePartnerRecordImpl {
  public static final String MODEL_NAME = "partner";

  @Column(
      name = "\"id\"",
      nullable = true,
      insertable = true,
      updatable = true
  )
  private long id = 0;

  public ImplPartnerJPA(Supplier<QueryPath> getPath) {
    super(MODEL_NAME, getPath);
  }

  public ImplPartnerJPA() {
    super(MODEL_NAME);
  }

  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  @Override
  public LongField id() {
    return new LongFieldImpl("id", this::getPath, this::getId, this::setId);
  }
}
