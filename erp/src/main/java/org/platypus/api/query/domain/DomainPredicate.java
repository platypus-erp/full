package org.platypus.api.query.domain;

import org.platypus.api.annotations.doc.InternalUse;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
@InternalUse
public enum DomainPredicate {
    EQ,
    I_EQ,
    IN,
    I_IN,
    BETWEEN,
    LESS,
    LESS_EQ,
    MORE,
    MORE_EQ,
    START_WITH,
    END_WITH,
    CONTAINS,
    I_START_WITH,
    I_END_WITH,
    I_CONTAINS,
    IS_NOT_NULL,
    IS_NULL,

}
