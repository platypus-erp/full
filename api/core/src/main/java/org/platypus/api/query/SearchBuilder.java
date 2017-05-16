package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.query.predicate.MultiQueryPredicate;
import org.platypus.api.query.predicate.QueryPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SearchBuilder<T extends Record> {
    List<ProjectionField<T>> projection = new ArrayList<>();
    MultiQueryPredicate<T, ?, ?> predicate;
    List<SortField<T>> sort = new ArrayList<>();

    private SearchBuilder() {
    }

    public static <T extends Record> SearchBuilder<T> from(Class<T> aClass) {
        return new SearchBuilder<>();
    }

    public SearchBuilder<T> add(Function<T, PlatypusField> field) {
        add(new ProjectionField<>(field));
        return this;
    }

    public SearchBuilder<T> add(ProjectionField<T> field) {
        projection.add(field);
        return this;
    }

    public <T1> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate) {
        return this;
    }

    public <T1, T2> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                           PredicateCombinator combinator,
                                           Function<T, QueryPredicate<T2>> predicate2) {
        return this;
    }

    public <T1, T2, T3> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                               PredicateCombinator combinator1,
                                               Function<T, QueryPredicate<T2>> predicate2,
                                               PredicateCombinator combinator2,
                                               Function<T, QueryPredicate<T3>> predicate3) {
        return this;
    }

    public <T1, T2, T3, T4> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                   PredicateCombinator combinator1,
                                                   Function<T, QueryPredicate<T2>> predicate2,
                                                   PredicateCombinator combinator2,
                                                   Function<T, QueryPredicate<T3>> predicate3,
                                                   PredicateCombinator combinator3,
                                                   Function<T, QueryPredicate<T4>> predicate4) {
        return this;
    }

    public <T1, T2, T3, T4, T5> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                       PredicateCombinator combinator1,
                                                       Function<T, QueryPredicate<T2>> predicate2,
                                                       PredicateCombinator combinator2,
                                                       Function<T, QueryPredicate<T3>> predicate3,
                                                       PredicateCombinator combinator3,
                                                       Function<T, QueryPredicate<T4>> predicate4,
                                                       PredicateCombinator combinator4,
                                                       Function<T, QueryPredicate<T5>> predicate5) {
        return this;
    }

    public <T1, T2, T3, T4, T5, T6> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                           PredicateCombinator combinator1,
                                                           Function<T, QueryPredicate<T2>> predicate2,
                                                           PredicateCombinator combinator2,
                                                           Function<T, QueryPredicate<T3>> predicate3,
                                                           PredicateCombinator combinator3,
                                                           Function<T, QueryPredicate<T4>> predicate4,
                                                           PredicateCombinator combinator4,
                                                           Function<T, QueryPredicate<T5>> predicate5,
                                                           PredicateCombinator combinator5,
                                                           Function<T, QueryPredicate<T6>> predicate6) {
        return this;
    }

    public <T1, T2, T3, T4, T5, T6, T7> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                               PredicateCombinator combinator1,
                                                               Function<T, QueryPredicate<T2>> predicate2,
                                                               PredicateCombinator combinator2,
                                                               Function<T, QueryPredicate<T3>> predicate3,
                                                               PredicateCombinator combinator3,
                                                               Function<T, QueryPredicate<T4>> predicate4,
                                                               PredicateCombinator combinator4,
                                                               Function<T, QueryPredicate<T5>> predicate5,
                                                               PredicateCombinator combinator5,
                                                               Function<T, QueryPredicate<T6>> predicate6,
                                                               PredicateCombinator combinator6,
                                                               Function<T, QueryPredicate<T7>> predicate7) {
        return this;
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                                   PredicateCombinator combinator1,
                                                                   Function<T, QueryPredicate<T2>> predicate2,
                                                                   PredicateCombinator combinator2,
                                                                   Function<T, QueryPredicate<T3>> predicate3,
                                                                   PredicateCombinator combinator3,
                                                                   Function<T, QueryPredicate<T4>> predicate4,
                                                                   PredicateCombinator combinator4,
                                                                   Function<T, QueryPredicate<T5>> predicate5,
                                                                   PredicateCombinator combinator5,
                                                                   Function<T, QueryPredicate<T6>> predicate6,
                                                                   PredicateCombinator combinator6,
                                                                   Function<T, QueryPredicate<T7>> predicate7,
                                                                   PredicateCombinator combinator7,
                                                                   Function<T, QueryPredicate<T8>> predicate8) {
        return this;
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                                       PredicateCombinator combinator1,
                                                                       Function<T, QueryPredicate<T2>> predicate2,
                                                                       PredicateCombinator combinator2,
                                                                       Function<T, QueryPredicate<T3>> predicate3,
                                                                       PredicateCombinator combinator3,
                                                                       Function<T, QueryPredicate<T4>> predicate4,
                                                                       PredicateCombinator combinator4,
                                                                       Function<T, QueryPredicate<T5>> predicate5,
                                                                       PredicateCombinator combinator5,
                                                                       Function<T, QueryPredicate<T6>> predicate6,
                                                                       PredicateCombinator combinator6,
                                                                       Function<T, QueryPredicate<T7>> predicate7,
                                                                       PredicateCombinator combinator7,
                                                                       Function<T, QueryPredicate<T8>> predicate8,
                                                                       PredicateCombinator combinator8,
                                                                       Function<T, QueryPredicate<T9>> predicate9) {
        return this;
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SearchBuilder<T> where(Function<T, QueryPredicate<T1>> predicate1,
                                                                            PredicateCombinator combinator1,
                                                                            Function<T, QueryPredicate<T2>> predicate2,
                                                                            PredicateCombinator combinator2,
                                                                            Function<T, QueryPredicate<T3>> predicate3,
                                                                            PredicateCombinator combinator3,
                                                                            Function<T, QueryPredicate<T4>> predicate4,
                                                                            PredicateCombinator combinator4,
                                                                            Function<T, QueryPredicate<T5>> predicate5,
                                                                            PredicateCombinator combinator5,
                                                                            Function<T, QueryPredicate<T6>> predicate6,
                                                                            PredicateCombinator combinator6,
                                                                            Function<T, QueryPredicate<T7>> predicate7,
                                                                            PredicateCombinator combinator7,
                                                                            Function<T, QueryPredicate<T8>> predicate8,
                                                                            PredicateCombinator combinator8,
                                                                            Function<T, QueryPredicate<T9>> predicate9,
                                                                            PredicateCombinator combinator9,
                                                                            Function<T, QueryPredicate<T10>> predicate10) {
        return this;

    }

    public SearchBuilder<T> sortAsc(Function<T, PlatypusField> field) {
        this.sort.add(new SortField<>(field, true));
        return this;
    }

    public SearchBuilder<T> sortDesc(Function<T, PlatypusField> field) {
        this.sort.add(new SortField<>(field, false));
        return this;
    }
}
