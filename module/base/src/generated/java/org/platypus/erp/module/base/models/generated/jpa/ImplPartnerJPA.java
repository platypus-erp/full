package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;

@Table(
    name = ImplPartnerJPA.MODEL_NAME
)
@Entity
public class ImplPartnerJPA implements BasePartnerRecord {
  public static final String MODEL_NAME = "partner";

  public ImplPartnerJPA() {
  }
}
