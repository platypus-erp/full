package org.platypus.sample.sample_depends.generated.model.jpa;

import java.lang.Class;
import java.lang.Override;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.impl.RecordImpl;
import org.platypus.sample.sample_depends.generated.records.TestModelRecord;

public class TestModelRecordImpl<T extends Record> extends RecordImpl<T, TestModelRecord, ImplTestJPA> implements TestModelRecord {
  public TestModelRecordImpl(T instance, Class<ImplTestJPA> targetRecordImpl,
      Function<T, ImplTestJPA> getter, BiConsumer<T, ImplTestJPA> setter) {
    super(instance, targetRecordImpl, getter, setter);}

  @Override
  public StringField name() {
    return get().name();}

  @Override
  public void name(final StringField name) {
    get().name(name);}
}
