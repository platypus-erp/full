package org.platypus.sample.sample_dependsmodel.jpa;

import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(
    name = ImplTestJPA.MODEL_NAME
)
@Entity
public class ImplTestJPA {
  public static final String MODEL_NAME = "test";

  @Column(
      name = "\"name\"",
      insertable = true,
      updatable = true
  )
  private String name;

  public String getname() {
    return this.name;}

  public void setName(final String name) {
    this.name = name;}
}
