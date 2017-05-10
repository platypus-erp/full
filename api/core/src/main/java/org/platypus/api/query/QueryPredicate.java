package org.platypus.api.query;

import org.platypus.api.UnmutableGenericField;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface QueryPredicate {

    UnmutableGenericField<?> getColumn();
    SqlPredicate getPredicate();
    Object getValue();
}
