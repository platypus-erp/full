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
public interface QuerySort<T extends Record> {

    void addAsc(Function<T, PProjection> asc);
    void addDesc(Function<T, PProjection> asc);

    List<PProjection> applyAsc(T instance);
    List<PProjection> applyDesc(T instance);
}
