package org.platypus.erp.module.base.models.generated.records;

import org.platypus.api.Record;
import org.platypus.api.annotations.record.RecordOf;
import org.platypus.api.fields.LongField;

@RecordOf(
    modelPkg = "org.platypus.erp.module.base.models",
    modelClassName = "Partner",
    modelName = "partner"
)
public interface BasePartnerRecord extends Record {

    @Override
    default LongField id() {
        return null;
    }
}
