package org.platypus.api.query.predicate.impl;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.fields.StringField;
import org.platypus.api.query.SqlPredicate;
import org.platypus.api.query.predicate.QueryPredicate;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/05/17.
 */
public class PredicateImpl<T extends PlatypusField> implements QueryPredicate<T> {

    final T field;
    T value;
    SqlPredicate sqlPredicate;

    public PredicateImpl(T field, SqlPredicate sqlPredicate, T value){
        this.field = field;
        this.sqlPredicate = sqlPredicate;
        this.value = value;
    }

    @Override
    public T getLeft() {
        return null;
    }

    @Override
    public SqlPredicate getCondition() {
        return sqlPredicate;
    }

    @Override
    public T getRight() {
        return value;
    }
}
