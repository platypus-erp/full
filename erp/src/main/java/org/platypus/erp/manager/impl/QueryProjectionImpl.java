package org.platypus.erp.manager.impl;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.query.ProjectionGetter;
import org.platypus.api.query.projection.PProjection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class QueryProjectionImpl<R extends Record>{
    List<ProjectionGetter<R>> projections;

    void postCreate(){
        projections = new ArrayList<>();
    }

    public void addProjection(ProjectionGetter<R> projection) {
        projections.add(projection);
    }

    public List<PProjection> apply(R instance) {
        return this.projections.stream()
                .map(p -> p.apply(instance))
                .map(PlatypusField::getProjection)
                .collect(Collectors.toList());
    }

    public boolean isEmpty(){
        return projections.isEmpty();
    }
}
