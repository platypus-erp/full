package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.query.predicate.FilterContainer;
import org.platypus.api.query.predicate.QueryPredicate;
import org.platypus.api.query.predicate.impl.PredicateHolder;
import org.platypus.api.query.predicate.impl.PredicateTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SearchBuilder<T extends Record> /*implements SearchDomainBuilder<T>*/ {
    private final Class<T> classResult;
    List<ProjectionField<T>> projection = new ArrayList<>();
    PredicateTree<T> predicateTree = new PredicateTree<>();
    List<SortField<T>> sort = new ArrayList<>();

    private SearchBuilder(Class<T> aClass) {
        classResult = aClass;
    }

    public static <T extends Record> SearchBuilder<T> from(Class<T> aClass) {
        return new SearchBuilder<>(aClass);
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


    public SearchBuilder<T> filter(Function<T, QueryPredicate<? extends PlatypusField>> predicate) {
        predicateTree = predicateTree.addNext(new FilterContainer<>(predicate));
        return this;
    }

    public SearchBuilder<T> or() {
        predicateTree = predicateTree.or();
        return this;
    }

    public SearchBuilder<T> and() {
        predicateTree = predicateTree.and();
        return this;
    }

    //<editor-fold desc="Over load filter">
    public SearchBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
                                   PredicateCombinator combinator1,
                                   Function<T, QueryPredicate<?>> predicate2) {
        predicateTree = predicateTree.addNext(new FilterContainer<>(predicate1, combinator1, predicate2));
        return this;
    }


    public SearchBuilder<T> filter(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                                         PredicateCombinator combinator1,
                                         Function<T, QueryPredicate<?>> predicate2,
                                         PredicateCombinator combinator2,
                                         Function<T, QueryPredicate<?>> predicate3,
                                         PredicateCombinator combinator3,
                                         Function<T, QueryPredicate<?>> predicate4,
                                         PredicateCombinator combinator4,
                                         Function<T, QueryPredicate<?>> predicate5,
                                         PredicateCombinator combinator5,
                                         Function<T, QueryPredicate<?>> predicate6,
                                         PredicateCombinator combinator6,
                                         Function<T, QueryPredicate<?>> predicate7,
                                         PredicateCombinator combinator7,
                                         Function<T, QueryPredicate<?>> predicate8,
                                         PredicateCombinator combinator8,
                                         Function<T, QueryPredicate<?>> predicate9,
                                         PredicateCombinator combinator9,
                                         Function<T, QueryPredicate<?>> predicate10) {
        predicateTree = predicateTree.addNext(new FilterContainer<>(
                predicate1, combinator1,
                predicate2,combinator2,
                predicate3,combinator3,
                predicate4,combinator4,
                predicate5,combinator5,
                predicate6,combinator6,
                predicate7,combinator7,
                predicate8,combinator8,
                predicate9,combinator9,
                predicate10
                ));

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

    public List<ProjectionField<T>> getProjection() {
        return projection;
    }

    PredicateTree<T> getPredicateTree() {
        return predicateTree;
    }

    List<SortField<T>> getSort() {
        return sort;
    }

    public Class<T> getClassResult() {
        return classResult;
    }
}
