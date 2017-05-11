package org.platypus.api.query;

import org.platypus.api.fields.UnmutableBooleanField;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface BooleanFieldQuery {


    QueryPredicate<Boolean> isTrue();

    QueryPredicate<Boolean> isFalse();

    QueryPredicate<Boolean> isUnSet();

    QueryPredicate<Boolean> isUnSetOrTrue();

    QueryPredicate<Boolean> isUnSetOrFalse();

    QueryPredicate<Boolean> isSet();

    QueryPredicate<Boolean> eq(boolean value);


}
