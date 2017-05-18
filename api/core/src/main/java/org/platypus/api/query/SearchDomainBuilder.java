package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.predicate.QueryPredicate;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public interface SearchDomainBuilder<T extends Record> {

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate);

    SearchDomainBuilder<T> or();

    SearchDomainBuilder<T> and();

    //<editor-fold desc="Overload filter method">
    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
                                           PredicateCombinator combinator,
                                           Function<T, QueryPredicate<?>> predicate2);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
                                               PredicateCombinator combinator1,
                                               Function<T, QueryPredicate<?>> predicate2,
                                               PredicateCombinator combinator2,
                                               Function<T, QueryPredicate<?>> predicate3);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
                                             PredicateCombinator combinator1,
                                             Function<T, QueryPredicate<?>> predicate2,
                                             PredicateCombinator combinator2,
                                             Function<T, QueryPredicate<?>> predicate3,
                                             PredicateCombinator combinator3,
                                             Function<T, QueryPredicate<?>> predicate4);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
                                                 PredicateCombinator combinator1,
                                                 Function<T, QueryPredicate<?>> predicate2,
                                                 PredicateCombinator combinator2,
                                                 Function<T, QueryPredicate<?>> predicate3,
                                                 PredicateCombinator combinator3,
                                                 Function<T, QueryPredicate<?>> predicate4,
                                                 PredicateCombinator combinator4,
                                                 Function<T, QueryPredicate<?>> predicate5);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
                                                     PredicateCombinator combinator1,
                                                     Function<T, QueryPredicate<?>> predicate2,
                                                     PredicateCombinator combinator2,
                                                     Function<T, QueryPredicate<?>> predicate3,
                                                     PredicateCombinator combinator3,
                                                     Function<T, QueryPredicate<?>> predicate4,
                                                     PredicateCombinator combinator4,
                                                     Function<T, QueryPredicate<?>> predicate5,
                                                     PredicateCombinator combinator5,
                                                     Function<T, QueryPredicate<?>> predicate6);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
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
                                                         Function<T, QueryPredicate<?>> predicate7);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
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
                                                             Function<T, QueryPredicate<?>> predicate8);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
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
                                                                 Function<T, QueryPredicate<?>> predicate9);

    SearchDomainBuilder<T> filter(Function<T, QueryPredicate<?>> predicate1,
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
                                                                      Function<T, QueryPredicate<?>> predicate10);
    //</editor-fold>
}
