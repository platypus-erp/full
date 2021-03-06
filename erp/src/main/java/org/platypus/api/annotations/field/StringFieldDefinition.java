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
public @interface StringFieldDefinition {
    String DEFAULT = "__DEFAULT__VALUE__";
    /**
     * = Asciidoclet
     * tag::insertable[]
     * *Optional*
     *
     * Whether the column is included in SQL INSERT
     * statements generated by the persistence provider.
     *
     * end::insertable[]
     */
    Bool insertable() default Bool.DEFAULT;
    Bool readonly() default Bool.DEFAULT;

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
     * The Unique constraint methodName will be UK_<target>_<hint> (ex :  UK_PARTNER_EMAIL)<br>
     * <bold>Warning</bold> if the default value is the same for all same hint value a compile error will be throw<br>
     * To erase the unique constraint set the hint to the default value witch is ""<br>
     */
    String uniqueHint() default DEFAULT;

    /**
     * (Optional) Only if you want to erase all the definition of this aggregate defined in other ui
     */
    boolean eraseWithYours() default false;

    int maxSize() default Integer.MAX_VALUE;

    int minSize() default Integer.MIN_VALUE;

    /**
     * (Optional) <br> Define if this aggregate can be <code>null</code> when the model is inserted or updated
     */
    RequiredType required() default RequiredType.NONE;

    String match() default DEFAULT;

    RemoveSpaceType removeSpace() default RemoveSpaceType.NONE;

    String defaultValue() default DEFAULT;
}
