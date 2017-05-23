package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.query.SqlPredicate;
import org.platypus.api.query.predicate.impl.PredicateImpl;
import org.platypus.api.query.predicate.QueryPredicate;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface StringField extends GenericField<String> {

    default QueryPredicate<StringField> eq(String value){
        return new PredicateImpl<>(this, SqlPredicate.EQ, StringField.of(value));
    }

    default QueryPredicate<StringField> isNull(){
        return new PredicateImpl<>(this, SqlPredicate.IS_NULL, StringField.empty());
    }

    default QueryPredicate<StringField> isNotNull(){
        return new PredicateImpl<>(this, SqlPredicate.IS_NOT_NULL, StringField.empty());
    }

    default QueryPredicate<StringField> contains(String value){
        return new PredicateImpl<>(this, SqlPredicate.LIKE, StringField.of(value));
    }

    default QueryPredicate<StringField> startWith(String value){
        return new PredicateImpl<>(this, SqlPredicate.LIKE, StringField.of(value));
    }

    default QueryPredicate<StringField> endWith(String value){
        return new PredicateImpl<>(this, SqlPredicate.EQ, StringField.of(value));
    }

    default boolean match(String regex){
        return match(regex, false);
    }
    default boolean match(String regex, boolean defaultValueIfEmpty){
        return isEmpty() ? defaultValueIfEmpty : this.get().matches(regex);
    }


    static StringField of(String value) {
        return null;
    }

    static StringField empty() {
        return null;
    }
}
