package org.platypus.api.annotations.field;


import org.platypus.api.Bool;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public @interface RelatedFieldDefinition {

    /**
     * The path to the value
     */
    String[] path();

    Bool store() default Bool.DEFAULT;

    Bool readonly() default Bool.DEFAULT;
}
