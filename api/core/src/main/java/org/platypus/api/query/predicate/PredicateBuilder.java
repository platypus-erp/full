package org.platypus.api.query.predicate;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.fields.DateField;
import org.platypus.api.fields.StringField;
import org.platypus.api.query.ProjectionField;
import org.platypus.api.query.SqlAggregator;
import org.platypus.api.query.SqlPredicate;

import java.time.LocalDate;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 12/05/17.
 */
public class PredicateBuilder<T extends Record> {

    public ProjectionField<T> concat(Function<T, StringField> stringField, String separator){
        return new ProjectionField<>(stringField, SqlAggregator.CONCAT, separator);
    }

    public ProjectionField<T> max(Function<T, PlatypusField> stringField){
        return new ProjectionField<>(stringField, SqlAggregator.MAX);
    }

    public ProjectionField<T> min(Function<T, PlatypusField> stringField){
        return new ProjectionField<>(stringField, SqlAggregator.MIN);
    }

    public ProjectionField<T> sum(Function<T, PlatypusField> stringField){
        return new ProjectionField<>(stringField, SqlAggregator.SUM);
    }

    public ProjectionField<T> avg(Function<T, PlatypusField> stringField){
        return new ProjectionField<>(stringField, SqlAggregator.AVG);
    }

    public ProjectionField<T> count(Function<T, PlatypusField> stringField){
        return new ProjectionField<>(stringField, SqlAggregator.COUNT);
    }






}
