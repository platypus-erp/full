package org.platypus.erp.module.base.models.generated.records;

import org.platypus.api.Record;
import org.platypus.api.annotations.record.RecordOf;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;
import org.platypus.api.query.SearchBuilder;

@RecordOf(
        modelPkg = "org.platypus.erp.module.base.models",
        modelClassName = "Users",
        modelName = "users"
)
public interface BaseUsersRecord extends Record {


    BinaryField signature();

    void signature(BinaryField signature);

    BooleanField active();

    BooleanField share();

    void active(BooleanField active);

    void share(BooleanField share);

    StringField password();

    StringField login();

    StringField new_password();

    void password(StringField password);

    void login(StringField login);

    void new_password(StringField new_password);

    BaseGroupRecordCollection groups();

    BaseGroupRecordCollection action();

    BaseCompanyRecordCollection companies();

    void groups(BaseGroupRecordCollection groups);

    void action(BaseGroupRecordCollection action);

    void companies(BaseCompanyRecordCollection companies);

    BaseCompanyRecord company();

    void company(BaseCompanyRecord company);

    BasePartnerRecord partner();

    void partner(BasePartnerRecord partner);
}
