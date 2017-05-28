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
public interface SimpleQuery<R extends Record> extends QueryFilter<R>, QueryFlag<R>{

    SimpleQuery<R> distinct(boolean distinct);

    QueryFilter<R> get(Function<R, PProjection> field1);

    //<editor-fold desc="Over load method get">
    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7,
                       Function<R, PProjection> field8);

    QueryFilter<R> get(Function<R, PProjection> field1,
                       Function<R, PProjection> field2,
                       Function<R, PProjection> field3,
                       Function<R, PProjection> field4,
                       Function<R, PProjection> field5,
                       Function<R, PProjection> field6,
                       Function<R, PProjection> field7,
                       Function<R, PProjection> field8,
                       Function<R, PProjection> field9);

    QueryFilter<R> get(Function<R, PProjection> field1,
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


}
