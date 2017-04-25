package org.platypus.sample.sample_depends.model.jpa;

import java.lang.Class;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.platypus.api.Record;
import org.platypus.api.fields.impl.RecordCollectionImpl;
import org.platypus.sample.sample_depends.records.TestModelRecord;
import org.platypus.sample.sample_depends.records.TestModelRecordCollection;

public class TestModelRecordCollectionImpl<T extends Record> extends RecordCollectionImpl<T, TestModelRecord, ImplTestJPA, TestModelRecordCollection> implements TestModelRecordCollection {
  public TestModelRecordCollectionImpl(T instance, Class<ImplTestJPA> recordTarget,
      Function<T, List<ImplTestJPA>> getter, BiConsumer<T, List<ImplTestJPA>> setter) {
    super(instance, recordTarget, getter, setter);}
}
