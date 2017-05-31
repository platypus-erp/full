package org.platypus.api.annotations.field;


import org.platypus.api.fields.Bool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DecimalFieldDefinition {
    String DEFAULT = "__DEFAULT__VALUE__";
    /**
     * (Optional) Whether the column is included in SQL INSERT
     * statements generated by the persistence provider.
     */
    Bool insertable() default Bool.DEFAULT;

    /**
     * (Optional) Whether the column is included in SQL UPDATE
     * statements generated by the persistence provider.
     */
    Bool updatable() default Bool.DEFAULT;

    /**
     * (Optional) The documentation put in the SQL column comment
     */
    String columnDoc() default DEFAULT;

    /**
     * (Optional) If the this column will be unique,<br>
     * if an another aggregate use the same hint(case insensitive)<br>
     * the the SQL Unique constraint will be above the two column<br>
     * The Unique constraint name will be UK_<target>_<hint> (ex :  UK_PARTNER_EMAIL)<br>
     * <bold>Warning</bold> if the default value is the same for all same hint value a compile error will be throw<br>
     * To erase the unique constraint set the hint to the default value witch is ""<br>
     */
    String uniqueHint() default DEFAULT;

    /**
     * (Optional) Only if you want to erase all the definition of this aggregate defined in other ui
     */
    boolean eraseWithYours() default false;

    /**
     * (Optional) <br> Define if this aggregate can be <code>null</code> when the model is inserted or updated
     */
    Bool required() default Bool.DEFAULT;

    /**
     * (Optional) <br> Define if the value of this aggregate can be change
     */
    Bool readonly() default Bool.DEFAULT;

    String defaultValue() default DEFAULT;

    float min() default Float.MIN_VALUE;

    float max() default Float.MAX_VALUE;
}
