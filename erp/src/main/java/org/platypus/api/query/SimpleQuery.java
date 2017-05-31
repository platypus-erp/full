package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.projection.PProjection;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface SimpleQuery<R extends Record>{

    Class<R> getTypeClass();

    SimpleQuery<R> get(Function<R, PProjection> field1);

    //<editor-fold desc="Over load method newRecord">
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

    SimpleQuery<R> filter(Domain<R> predicate);

    //<editor-fold desc="Over load method filter">
    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator,
                         Domain<R> predicate2);


    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3);

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4) ;

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4,
                         Domain.DomainCombinator combinator4,
                         Domain<R> predicate5);

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4,
                         Domain.DomainCombinator combinator4,
                         Domain<R> predicate5,
                         Domain.DomainCombinator combinator5,
                         Domain<R> predicate6);

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4,
                         Domain.DomainCombinator combinator4,
                         Domain<R> predicate5,
                         Domain.DomainCombinator combinator5,
                         Domain<R> predicate6,
                         Domain.DomainCombinator combinator6,
                         Domain<R> predicate7) ;

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4,
                         Domain.DomainCombinator combinator4,
                         Domain<R> predicate5,
                         Domain.DomainCombinator combinator5,
                         Domain<R> predicate6,
                         Domain.DomainCombinator combinator6,
                         Domain<R> predicate7,
                         Domain.DomainCombinator combinator7,
                         Domain<R> predicate8);

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4,
                         Domain.DomainCombinator combinator4,
                         Domain<R> predicate5,
                         Domain.DomainCombinator combinator5,
                         Domain<R> predicate6,
                         Domain.DomainCombinator combinator6,
                         Domain<R> predicate7,
                         Domain.DomainCombinator combinator7,
                         Domain<R> predicate8,
                         Domain.DomainCombinator combinator8,
                         Domain<R> predicate9);

    SimpleQuery<R> filter(Domain<R> predicate1,
                         Domain.DomainCombinator combinator1,
                         Domain<R> predicate2,
                         Domain.DomainCombinator combinator2,
                         Domain<R> predicate3,
                         Domain.DomainCombinator combinator3,
                         Domain<R> predicate4,
                         Domain.DomainCombinator combinator4,
                         Domain<R> predicate5,
                         Domain.DomainCombinator combinator5,
                         Domain<R> predicate6,
                         Domain.DomainCombinator combinator6,
                         Domain<R> predicate7,
                         Domain.DomainCombinator combinator7,
                         Domain<R> predicate8,
                         Domain.DomainCombinator combinator8,
                         Domain<R> predicate9,
                         Domain.DomainCombinator combinator9,
                         Domain<R> predicate10);
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


    PPredicate<?> getPredicate(R instance);

    boolean getAllField();

    List<PProjection> getProjection(R instance);
}
