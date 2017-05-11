package org.platypus.api.query;

import org.platypus.api.fields.BooleanField;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/05/17.
 */
public class RecordPredicate {

    final PredicateStep predicateStep;
    final boolean and;
    final BooleanField field;
    boolean value;
    SqlPredicate sqlPredicate;

    RecordPredicate(boolean and, BooleanField field, PredicateStep predicateStep){
        this.predicateStep = predicateStep;
        this.and = and;
        this.field = field;
    }

    public PredicateStep isNull(){
        this.value = true;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep isNotNull(){
        this.value = false;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep in(Collection<Long> ids){
        this.value = value;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }

    public PredicateStep notIn(Collection<Long> ids){
        this.value = value;
        this.sqlPredicate = SqlPredicate.EQ;
        return predicateStep;
    }


}
