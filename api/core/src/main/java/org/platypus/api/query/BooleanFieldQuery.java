package org.platypus.api.query;

import org.platypus.api.fields.UnmutableBooleanField;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface BooleanFieldQuery {


    QueryPredicate<UnmutableBooleanField> isTrue();
    QueryPredicate<UnmutableBooleanField> isFalse();
    QueryPredicate<UnmutableBooleanField> isUnSet();
    QueryPredicate<UnmutableBooleanField> isUnSetOrTrue();
    QueryPredicate<UnmutableBooleanField> isUnSetOrFalse();
    QueryPredicate<UnmutableBooleanField> isSet();
    QueryPredicate<UnmutableBooleanField> eq(boolean value);


}
