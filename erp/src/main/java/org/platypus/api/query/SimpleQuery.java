package org.platypus.api.query;

import org.platypus.api.Pool;
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
public interface SimpleQuery<R extends Record>{

    SimpleQuery<R> get(Function<R, PProjection> field1);

    //<editor-fold desc="Over load method get">
    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7,
                       Function<R, PProjection> field8);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7,
                       Function<R, PProjection> field8,
                       Function<R, PProjection> field9);

    SimpleQuery<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7,
                       Function<R, PProjection> field8,
                       Function<R, PProjection> field9,
                       Function<R, PProjection> field10);
    //</editor-fold>

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate);

    //<editor-fold desc="Over load method filter">
    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
                         DomainCombinator combinator,
                         Function<R, PPredicate<?>> predicate2);


    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
                         DomainCombinator combinator1,
                         Function<R, PPredicate<?>> predicate2,
                         DomainCombinator combinator2,
                         Function<R, PPredicate<?>> predicate3);

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
                         DomainCombinator combinator1,
                         Function<R, PPredicate<?>> predicate2,
                         DomainCombinator combinator2,
                         Function<R, PPredicate<?>> predicate3,
                         DomainCombinator combinator3,
                         Function<R, PPredicate<?>> predicate4) ;

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
                         DomainCombinator combinator1,
                         Function<R, PPredicate<?>> predicate2,
                         DomainCombinator combinator2,
                         Function<R, PPredicate<?>> predicate3,
                         DomainCombinator combinator3,
                         Function<R, PPredicate<?>> predicate4,
                         DomainCombinator combinator4,
                         Function<R, PPredicate<?>> predicate5);

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
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

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
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

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
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

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
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

    SimpleQuery<R> filter(Function<R, PPredicate<?>> predicate1,
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


    SimpleQuery<R> sortAsc(Function<R, PProjection> field1);

    SimpleQuery<R> sortAsc(Function<R, PProjection> field1,
                           Function<R, PProjection> field2);

    SimpleQuery<R> sortAsc(Function<R, PProjection> field1,
                           Function<R, PProjection> field2,
                           Function<R, PProjection> field3);

    SimpleQuery<R> sortDesc(Function<R, PProjection> field1);

    SimpleQuery<R> sortDesc(Function<R, PProjection> field1,
                            Function<R, PProjection> field2);

    SimpleQuery<R> sortDesc(Function<R, PProjection> field1,
                            Function<R, PProjection> field2,
                            Function<R, PProjection> field3);


}
