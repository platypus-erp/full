package org.platypus.erp.module.base.models.generated.jpa;

import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.erp.module.base.models.generated.records.GroupRecord;

@Table(
    name = ImplGroupJPA.MODEL_NAME
)
@Entity
public class ImplGroupJPA implements GroupRecord {
  public static final String MODEL_NAME = "group";

  public ImplGroupJPA() {
  }
}
