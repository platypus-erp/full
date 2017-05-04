package org.platypus.api.annotations.model;

/**
 * Created by apasquier on 04/05/17.
 */
public @interface ModelOrderBy {

    String[] asc() default {};
    String[] desc() default {};
}
