package org.platypus.api.query;

import org.platypus.api.query.QueryComplexePredicate;
import org.platypus.api.query.QueryPredicate;

import java.util.function.Function;

/**
 * Created by apasquier on 11/05/17.
 */
public interface Filter {

    @FunctionalInterface
    interface Complexe<R> extends Function<R, QueryComplexePredicate> {

    }

    @FunctionalInterface
    interface Basic<R> extends Function<R, QueryPredicate> {

    }
}
