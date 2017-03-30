package org.platypus.api.annotations.field;


import org.platypus.api.BaseModel;
import org.platypus.api.Bool;

/**
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public @interface ManyToOneFieldDefinition {
    String DEFAULT = "__DEFAULT__VALUE__";

    /**
     * The target Platypus model for the relation
     */
    Class<? extends BaseModel> value();
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
     * (Optional) <br> Only if you want to erase all the definition of this field defined in other module
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
     * (Optional) Define if the field can be <code>null</code>
     */
    Bool required() default Bool.DEFAULT;
}
