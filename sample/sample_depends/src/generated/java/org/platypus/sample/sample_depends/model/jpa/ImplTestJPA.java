package org.platypus.sample.sample_depends.model.jpa;

import java.lang.Override;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.StringFieldImpl;
import org.platypus.sample.sample_depends.records.TestModelRecord;

@Table(
    name = ImplTestJPA.MODEL_NAME
)
@Entity
public class ImplTestJPA implements TestModelRecord {
  public static final String MODEL_NAME = "test";

  @Column(
      name = "\"name\"",
      insertable = true,
      updatable = true
  )
  private String name;

  private final StringField nameInheritField;

  public ImplTestJPA() {
    nameInheritField = new StringFieldImpl<>(this, ImplTestJPA::getName, ImplTestJPA::setName);}

  public String getName() {
    return this.name;}

  public void setName(final String name) {
    this.name = name;}

  @Override
  public void name(final StringField nameInheritField) {
    this.setName(nameInheritField.get());}

  @Override
  public StringField name() {
    return nameInheritField;}
}
