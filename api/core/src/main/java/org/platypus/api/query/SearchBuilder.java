package org.platypus.api.query;

import org.platypus.api.Pathable;
import org.platypus.api.Record;
import org.platypus.api.UnmutableGenericField;
import org.platypus.api.fields.BooleanField;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SearchBuilder<R extends Record> {
    List<QueryPath> projection = new ArrayList<>();

    public static <T extends Record> SearchBuilder<T> from(Class<T> record){
        return new SearchBuilder<>();
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

    public SearchBuilder<R> filter(QueryPredicate filter){
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
