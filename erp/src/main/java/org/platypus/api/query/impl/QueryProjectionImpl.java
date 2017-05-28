package org.platypus.api.query.impl;

import org.platypus.api.Record;
import org.platypus.api.annotations.doc.InternalUse;
import org.platypus.api.annotations.doc.ShouldBeInject;
import org.platypus.api.query.QueryProjection;
import org.platypus.api.query.projection.PProjection;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
@InternalUse
@ShouldBeInject(QueryProjection.class)
public class QueryProjectionImpl<R extends Record> implements QueryProjection<R>{
    List<Function<R, PProjection>> projections;

    @PostConstruct
    void postCreate(){
        projections = new ArrayList<>();
    }

    @Override
    public void addProjection(Function<R, PProjection> projection) {
        projections.add(projection);
    }

    @Override
    public List<PProjection> apply(R instance) {
        return this.projections.stream()
                .map(p -> p.apply(instance))
                .collect(Collectors.toList());
    }
}
