package org.platypus.module.base.models;

import org.platypus.api.BaseModel;
import org.platypus.api.Bool;
import org.platypus.api.annotations.field.*;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.NewField;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
@PlatypusModel("user")
//order 'name, login'
public class User implements BaseModel{

    @IntFieldDefinition
    NewField id;

    @ManyToOneFieldDefinition(value = Partner.class, required = Bool.TRUE)
    NewField partner;

    @StringFieldDefinition(maxSize = 64, required = RequiredType.NOT_BLANK, uniqueHint = "login")
    NewField login;

    @StringFieldDefinition
    NewField password;

    @StringFieldDefinition
    NewField new_password;

    @BinaryFieldDefinition
    NewField signature;

//    @ManyToManyFieldDefinition()
//    NewField action;

    @ManyToManyFieldDefinition(Group.class)
    NewField groups;

    @ManyToOneFieldDefinition(Company.class)
    NewField company_id;

    @BooleanFieldDefinition
    NewField share;


}
