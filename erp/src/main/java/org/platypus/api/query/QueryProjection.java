package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.projection.PProjection;

import java.util.List;
import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface QueryProjection<R extends Record> {

    void addProjection(Function<R, PProjection> projection);

    List<PProjection> apply(R instance);
}
