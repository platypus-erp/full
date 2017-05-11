package org.platypus.api.query;

import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.StringField;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/05/17.
 */
public class BooleanPredicate {

    final PredicateStep predicateStep;
    final boolean and;
    final BooleanField field;
    boolean value;
    SqlPredicate sqlPredicate;

    BooleanPredicate(boolean and, BooleanField field, PredicateStep predicateStep){
        this.predicateStep = predicateStep;
        this.and = and;
        this.field = field;
    }

    public PredicateStep isTrue(){
        this.value = true;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep isFalse(){
        this.value = false;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep eq(boolean value){
        this.value = value;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }


}
