package org.platypus.api.query;

import org.platypus.api.fields.StringField;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/05/17.
 */
public class StringPredicate {

    final PredicateStep predicateStep;
    final boolean and;
    final StringField field;
    String value;
    SqlPredicate sqlPredicate;

    StringPredicate(boolean and, StringField field, PredicateStep predicateStep){
        this.predicateStep = predicateStep;
        this.and = and;
        this.field = field;
    }

    public PredicateStep eq(String value){
        this.value = value;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep isNull(){
        this.value = null;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep isNotNull(){
        this.value = null;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep contains(String value){
        this.value = value;
        this.sqlPredicate = SqlPredicate.LIKE;
        return predicateStep;
    }

    public PredicateStep startWith(String value){
        this.value = value;
        this.sqlPredicate = SqlPredicate.LIKE;
        return predicateStep;
    }

    public PredicateStep endWith(String value){
        this.value = value;
        this.sqlPredicate = SqlPredicate.LIKE;
        return predicateStep;
    }



}
