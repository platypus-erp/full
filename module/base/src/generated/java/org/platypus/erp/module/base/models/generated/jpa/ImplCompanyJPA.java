package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.erp.module.base.models.generated.records.CompanyRecord;

@Table(
    name = ImplCompanyJPA.MODEL_NAME
)
@Entity
public class ImplCompanyJPA implements CompanyRecord {
  public static final String MODEL_NAME = "company";

  public ImplCompanyJPA() {
  }
}
