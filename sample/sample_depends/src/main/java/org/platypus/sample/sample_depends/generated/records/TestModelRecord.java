package org.platypus.sample.sample_depends.generated.records;

import org.platypus.api.Record;
import org.platypus.api.fields.StringField;

public interface TestModelRecord extends Record {
  StringField name();

  void name(StringField name);
}
