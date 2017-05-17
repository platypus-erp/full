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
    List<SortField<T>> sort = new ArrayList<>();

    private SearchBuilder() {
    }

    public static <T extends Record> SearchBuilder<T> from(Class<T> aClass) {
        return new SearchBuilder<>();
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field) {
        return get(new ProjectionField<>(field));
    }

    public SearchBuilder<T> get(ProjectionField<T> field) {
        projection.add(field);
        return this;
    }

    //<editor-fold desc="Over load get Methode">
    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2) {
        return get(field1).get(field2);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3) {
        return get(field1, field2).get(field3);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4) {
        return get(field1, field2, field3).get(field4);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4,
                                Function<T, PlatypusField> field5) {
        return get(field1, field2, field3, field4).get(field5);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4,
                                Function<T, PlatypusField> field5,
                                Function<T, PlatypusField> field6) {
        return get(field1, field2, field3, field4, field5).get(field6);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4,
                                Function<T, PlatypusField> field5,
                                Function<T, PlatypusField> field6,
                                Function<T, PlatypusField> field7) {
        return get(field1, field2, field3, field4, field5, field6).get(field7);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4,
                                Function<T, PlatypusField> field5,
                                Function<T, PlatypusField> field6,
                                Function<T, PlatypusField> field7,
                                Function<T, PlatypusField> field8) {
        return get(field1, field2, field3, field4, field5, field6, field7).get(field8);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4,
                                Function<T, PlatypusField> field5,
                                Function<T, PlatypusField> field6,
                                Function<T, PlatypusField> field7,
                                Function<T, PlatypusField> field8,
                                Function<T, PlatypusField> field9) {
        return get(field1, field2, field3, field4, field5, field6, field7, field8).get(field9);
    }

    public SearchBuilder<T> get(Function<T, PlatypusField> field1,
                                Function<T, PlatypusField> field2,
                                Function<T, PlatypusField> field3,
                                Function<T, PlatypusField> field4,
                                Function<T, PlatypusField> field5,
                                Function<T, PlatypusField> field6,
                                Function<T, PlatypusField> field7,
                                Function<T, PlatypusField> field8,
                                Function<T, PlatypusField> field9,
                                Function<T, PlatypusField> field10) {
        return get(field1, field2, field3, field4, field5, field6, field7, field8, field9).get(field10);
    }
    //</editor-fold>

    public <T1> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate) {
        return this;
    }

    public SearchBuilder<T> or() {
        return this;
    }
    public SearchBuilder<T> and() {
        return this;
    }

    //<editor-fold desc="Overload filter method">
    public <T1, T2> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
                                            PredicateCombinator combinator,
                                            Function<T, QueryPredicate<T2>> predicate2) {
        return this;
    }

    public <T1, T2, T3> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
                                                PredicateCombinator combinator1,
                                                Function<T, QueryPredicate<T2>> predicate2,
                                                PredicateCombinator combinator2,
                                                Function<T, QueryPredicate<T3>> predicate3) {
        return this;
    }

    public <T1, T2, T3, T4> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
                                                    PredicateCombinator combinator1,
                                                    Function<T, QueryPredicate<T2>> predicate2,
                                                    PredicateCombinator combinator2,
                                                    Function<T, QueryPredicate<T3>> predicate3,
                                                    PredicateCombinator combinator3,
                                                    Function<T, QueryPredicate<T4>> predicate4) {
        return this;
    }

    public <T1, T2, T3, T4, T5> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
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

    public <T1, T2, T3, T4, T5, T6> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
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

    public <T1, T2, T3, T4, T5, T6, T7> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
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

    public <T1, T2, T3, T4, T5, T6, T7, T8> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
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

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
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

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SearchBuilder<T> filter(Function<T, QueryPredicate<T1>> predicate1,
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
    //</editor-fold>

    public SearchBuilder<T> sortAsc(Function<T, PlatypusField> field) {
        this.sort.add(new SortField<>(field, true));
        return this;
    }

    public SearchBuilder<T> sortDesc(Function<T, PlatypusField> field) {
        this.sort.add(new SortField<>(field, false));
        return this;
    }
}
