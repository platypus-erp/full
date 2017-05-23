package org.platypus.erp.module.base.models;

import org.platypus.api.BaseModel;
import org.platypus.api.Bool;
import org.platypus.api.annotations.field.BinaryFieldDefinition;
import org.platypus.api.annotations.field.BooleanFieldDefinition;
import org.platypus.api.annotations.field.ManyToManyFieldDefinition;
import org.platypus.api.annotations.field.ManyToOneFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.field.RequiredType;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.i18n.Help;
import org.platypus.api.annotations.i18n.Label;
import org.platypus.api.annotations.model.ModelOrderBy;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.NewField;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
@PlatypusModel("users")
@ModelOrderBy(asc = {"name", "login"})
public class Users implements BaseModel {

    @Label("Related Partner")
    @Help("Partner-related data of the user")
    @OneToOneFieldDefinition(target = Partner.class, required = Bool.TRUE)
    NewField partner;

    @Label("Login")
    @Help("Used to log into the system")
    @StringFieldDefinition(maxSize = 64, required = RequiredType.NOT_BLANK, uniqueHint = "login")
    NewField login;

    @Label("Password")
    @Help("Keep empty if you don't want the user to be able to connect on the system.")
    @StringFieldDefinition(maxSize = 64)
    NewField password;

    @Label("Set Password")
    @Help("Specify a value only when creating a user or if you're " +
            "changing the user's password, otherwise leave empty.\nAfter " +
            "a change of password, the user has to login again.")
    @StringFieldDefinition(maxSize = 64)
    NewField new_password;

    @Label("Signature")
    @BinaryFieldDefinition
    NewField signature;

    @Label("Active")
    @BooleanFieldDefinition
    NewField active;

    @Label("Home action")
    @Help("If specified, this action will be opened at log on for this user, in addition to the standard menu.")
    @ManyToManyFieldDefinition(target = Group.class)
    NewField action;

    @Label("Groups")
    @ManyToManyFieldDefinition(target = Group.class)
    NewField groups;

    @Label("Company")
    @ManyToOneFieldDefinition(target = Company.class)
    NewField company;

    @Label("Companies")
    @ManyToManyFieldDefinition(target = Company.class)
    NewField companies;

    @Label("Share Users")
    @Help("External user with limited access, created only for the purpose of sharing data.")
    @BooleanFieldDefinition
    NewField share;

}
