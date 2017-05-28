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
public interface QueryOrder<R extends Record> {

    QueryExecutor<R> sortAsc(Function<R, PProjection> field1);

    QueryExecutor<R> sortAsc(Function<R, PProjection> field1,
                          Function<R, PProjection> field2);

    QueryExecutor<R> sortAsc(Function<R, PProjection> field1,
                          Function<R, PProjection> field2,
                          Function<R, PProjection> field3);

    QueryExecutor<R> sortDesc(Function<R, PProjection> field1);

    QueryExecutor<R> sortDesc(Function<R, PProjection> field1,
                           Function<R, PProjection> field2);

    QueryExecutor<R> sortDesc(Function<R, PProjection> field1,
                           Function<R, PProjection> field2,
                           Function<R, PProjection> field3);


}
