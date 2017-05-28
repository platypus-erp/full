package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.domain.DomainCombinator;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.projection.PProjection;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface QueryFilter<R extends Record> {

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate);

    //<editor-fold desc="Over load method filter">
    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator,
                          Function<R, PPredicate<?>> predicate2);


    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3);

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4) ;

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4,
                          DomainCombinator combinator4,
                          Function<R, PPredicate<?>> predicate5);

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4,
                          DomainCombinator combinator4,
                          Function<R, PPredicate<?>> predicate5,
                          DomainCombinator combinator5,
                          Function<R, PPredicate<?>> predicate6);

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4,
                          DomainCombinator combinator4,
                          Function<R, PPredicate<?>> predicate5,
                          DomainCombinator combinator5,
                          Function<R, PPredicate<?>> predicate6,
                          DomainCombinator combinator6,
                          Function<R, PPredicate<?>> predicate7) ;

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4,
                          DomainCombinator combinator4,
                          Function<R, PPredicate<?>> predicate5,
                          DomainCombinator combinator5,
                          Function<R, PPredicate<?>> predicate6,
                          DomainCombinator combinator6,
                          Function<R, PPredicate<?>> predicate7,
                          DomainCombinator combinator7,
                          Function<R, PPredicate<?>> predicate8);

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4,
                          DomainCombinator combinator4,
                          Function<R, PPredicate<?>> predicate5,
                          DomainCombinator combinator5,
                          Function<R, PPredicate<?>> predicate6,
                          DomainCombinator combinator6,
                          Function<R, PPredicate<?>> predicate7,
                          DomainCombinator combinator7,
                          Function<R, PPredicate<?>> predicate8,
                          DomainCombinator combinator8,
                          Function<R, PPredicate<?>> predicate9);

    QueryOrder<R> filter(Function<R, PPredicate<?>> predicate1,
                          DomainCombinator combinator1,
                          Function<R, PPredicate<?>> predicate2,
                          DomainCombinator combinator2,
                          Function<R, PPredicate<?>> predicate3,
                          DomainCombinator combinator3,
                          Function<R, PPredicate<?>> predicate4,
                          DomainCombinator combinator4,
                          Function<R, PPredicate<?>> predicate5,
                          DomainCombinator combinator5,
                          Function<R, PPredicate<?>> predicate6,
                          DomainCombinator combinator6,
                          Function<R, PPredicate<?>> predicate7,
                          DomainCombinator combinator7,
                          Function<R, PPredicate<?>> predicate8,
                          DomainCombinator combinator8,
                          Function<R, PPredicate<?>> predicate9,
                          DomainCombinator combinator9,
                          Function<R, PPredicate<?>> predicate10);
    //</editor-fold>


    QueryFilter<R> sortAsc(Function<R, PProjection> field1);

    QueryFilter<R> sortAsc(Function<R, PProjection> field1,
                           Function<R, PProjection> field2);

    QueryFilter<R> sortAsc(Function<R, PProjection> field1,
                           Function<R, PProjection> field2,
                           Function<R, PProjection> field3);

    QueryFilter<R> sortDesc(Function<R, PProjection> field1);

    QueryFilter<R> sortDesc(Function<R, PProjection> field1,
                            Function<R, PProjection> field2);

    QueryFilter<R> sortDesc(Function<R, PProjection> field1,
                            Function<R, PProjection> field2,
                            Function<R, PProjection> field3);


}
