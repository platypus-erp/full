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
public @interface ManyToManyFieldDefinition {
    String DEFAULT = "__DEFAULT__VALUE__";

    /**
     * The target Platypus model for the relation
     */
    Class<? extends BaseModel> target();

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
     * (Optional) <br> Only if you want to erase all the definition of this field defined in other ui
     */
    boolean eraseWithYours() default false;
    /**
     * (Optional) The operations that must be cascaded to
     * the target of the association.
     *
     * <p> By default no operations are cascaded.
     */
    PlatypusCascadeType[] cascade() default {};

    /**
     * (Optional) a where predicate add to the query when the relation is fetched
     */
    String where() default DEFAULT;

    /**
     * (Optional) an <code>ORDER BY "field_name" ASC</code> clause add to the query when the relation is fetched
     */
    String sortAsc() default DEFAULT;

    /**
     * (Optional) an <code>ORDER BY "field_name" DESC</code> clause add to the query when the relation is fetched
     */
    String sortDesc() default DEFAULT;

    /**
     * (Optional) <br> Define if this field can be empty when the model is inserted or updated
     */
    Bool required() default Bool.DEFAULT;

    /**
     * (Optional) <br> Define if the value of this field can be change
     */
    Bool readonly() default Bool.DEFAULT;
}
