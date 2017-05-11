package org.platypus.api.query;

import org.platypus.api.Pathable;
import org.platypus.api.Record;
import org.platypus.api.UnmutableGenericField;
import org.platypus.api.fields.BooleanField;

import javax.swing.text.NavigationFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SearchBuilder<R extends Record> {
    List<QueryPath> projection = new ArrayList<>();
    R record;
    QueryComplexePredicate predicate;

    public SearchBuilder(R record) {
        this.record = record;
    }

    public static <T extends Record> SearchBuilder<T> search(T record){
        return new SearchBuilder<>(record);
    }

    public static QueryComplexePredicate and(QueryPredicate v1, QueryPredicate v2){
        return null;
    }

    public static QueryComplexePredicate and(QueryComplexePredicate v1, QueryPredicate v2){
        return null;
    }

    public static QueryComplexePredicate and(QueryComplexePredicate v1, QueryComplexePredicate v2){
        return null;
    }

    public static QueryComplexePredicate and(QueryPredicate v1, QueryComplexePredicate v2){
        return null;
    }



    public static QueryComplexePredicate or(QueryPredicate v1, QueryPredicate v2){
        return null;
    }

    public static QueryComplexePredicate or(QueryComplexePredicate v1, QueryPredicate v2){
        return null;
    }

    public static QueryComplexePredicate or(QueryComplexePredicate v1, QueryComplexePredicate v2){
        return null;
    }

    public static QueryComplexePredicate or(QueryPredicate v1, QueryComplexePredicate v2){
        return null;
    }

    public <COLUMN extends Pathable> SearchBuilder<R> get(COLUMN... projection){
        return this;
    }

    public <COLUMN extends Pathable> SearchBuilder<R> get(Function<R, COLUMN> projection){
        return this;
    }

    public SearchBuilder<R> filter(QueryPredicate filter){
        return this;
    }

    public SearchBuilder<R> filter(Filter.Complexe<R> filter){
        predicate = and(predicate, filter.apply(record));
        return this;
    }

    public SearchBuilder<R> filter(Filter.Basic<R> filter){
        predicate = and(predicate, filter.apply(record));
        return this;
    }

    public SearchBuilder<R> filter(QueryComplexePredicate filter){
        return this;
    }

    public <T> SearchBuilder<R> sortAsc(UnmutableGenericField<T>... asc){
        return this;
    }

    public <T> SearchBuilder<R> sortDesc(UnmutableGenericField<T>... asc){
        return this;
    }


    public Stream<R> stream(){
        return Stream.empty();
    }

    public Optional<R> first(){
        return Optional.empty();
    }

    public long count(){
        return 0;
    }






}
