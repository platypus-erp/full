package org.platypus.erp.manager.impl;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.annotations.doc.InternalUse;
import org.platypus.api.query.ProjectionGetter;
import org.platypus.api.query.projection.PProjection;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
@InternalUse
public class QuerySortImpl<R extends Record> {
    List<ProjectionGetter<R>> sortAsc;
    List<ProjectionGetter<R>> sortDesc;

    public QuerySortImpl(){
        sortAsc = new ArrayList<>();
        sortDesc = new ArrayList<>();
    }

    public void addAsc(ProjectionGetter<R> asc) {
        sortAsc.add(asc);
    }

    public void addDesc(ProjectionGetter<R> desc) {
        sortDesc.add(desc);
    }

    public List<PProjection> applyAsc(R instance) {
        return sortAsc.stream()
                .map(s -> s.apply(instance))
                .map(PlatypusField::getProjection)
                .collect(toList());
    }

    public List<PProjection> applyDesc(R instance) {
        return sortDesc.stream()
                .map(s -> s.apply(instance))
                .map(PlatypusField::getProjection)
                .collect(toList());
    }
}
