package org.platypus.sample.sample_depends.generated.model.jpa;

import java.lang.Override;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.api.fields.StringField;

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

  private final StringField name;

  public String getname() {
    return this.name;}

  public void setName(final String name) {
    this.name = name;}

  @Override
  public void name(final StringField name) {
    this.get().name(name);}

  @Override
  public StringField name() {
    return get().name();}
}
