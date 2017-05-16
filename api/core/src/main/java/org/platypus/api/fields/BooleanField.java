package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.query.SqlPredicate;
import org.platypus.api.query.predicate.PredicateImpl;
import org.platypus.api.query.predicate.QueryPredicate;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface BooleanField extends GenericField<Boolean> {

    default QueryPredicate<BooleanField> isTrue(){
        return new PredicateImpl<>(this, SqlPredicate.EQ, True());
    }

    default QueryPredicate<BooleanField> isFalse(){
        return new PredicateImpl<>(this, SqlPredicate.EQ, False());
    }

    default QueryPredicate<BooleanField> eq(boolean value){
        return new PredicateImpl<>(this, SqlPredicate.EQ, of(value));
    }

    default QueryPredicate<BooleanField> eq(BooleanField booleanField){
        return new PredicateImpl<>(this, SqlPredicate.EQ, booleanField);
    }

    static BooleanField of(boolean value) {
        return null;
    }

    static BooleanField True() {
        return null;
    }
    static BooleanField False() {
        return null;
    }


}
