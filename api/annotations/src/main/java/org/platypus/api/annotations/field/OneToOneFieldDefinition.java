package org.platypus.api.annotations.field;


import org.platypus.api.BaseModel;
import org.platypus.api.Bool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OneToOneFieldDefinition {
    String DEFAULT = "__DEFAULT__VALUE__";

    /**
     * The target Platypus model for the relation
     */
    Class<? extends BaseModel> target();

    /**
     * The mapped relation in the target model
     *
     * @see OneToOneFieldDefinition#target()
     */
    String mappedBy();

    /**
     * (Optional) <br> Define if this field can be updated<br>
     * The default value is equivalent to <code>true</code> if unset when the model will be generated<br>
     * when you inherit of a model the value will be define to the last value or <code>true</code>
     */
    Bool updatable() default Bool.DEFAULT;

    /**
     * (Optional) <br> The documentation put in the SQL column comment <br>
     * The default value is equivalent to an empty string <code>""</code>if unset when the model will be generated
     */
    String columnDoc() default DEFAULT;

    /**
     * (Optional) If the this column will be unique,<br>
     * if an another field use the same hint(case insensitive)<br>
     * the the SQL Unique constraint will be above the two column<br>
     * The Unique constraint name will be UK_<target>_<hint> (ex :  UK_PARTNER_EMAIL)<br>
     * <bold>Warning</bold> if the default value is the same for all same hint value a compile error will be throw<br>
     * To erase the unique constraint set the hint to the default value witch is ""<br>
     */
    String uniqueHint() default DEFAULT;

    /**
     * (Optional) <br> Only if you want to erase all the definition of this field defined in other module
     */
    boolean eraseWithYours() default false;

    /**
     * (Optional) The operations that must be cascaded to
     * the target of the association.
     * <p>
     * <p> By default no operations are cascaded.
     */
    PlatypusCascadeType[] cascade() default PlatypusCascadeType.DEFAULT;

    /**
     * (Optional) Define if the field can be <code>null</code>
     */
    Bool required() default Bool.DEFAULT;

    /**
     * (Optional) <br> Define if the value of this field can be change
     */
    Bool readonly() default Bool.DEFAULT;

}
