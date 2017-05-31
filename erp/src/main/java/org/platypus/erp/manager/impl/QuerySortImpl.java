package org.platypus.erp.manager.impl;

import org.platypus.api.Record;
import org.platypus.api.annotations.doc.InternalUse;
import org.platypus.api.query.projection.PProjection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
@InternalUse
public class QuerySortImpl<R extends Record> {
    List<Function<R, PProjection>> sortAsc;
    List<Function<R, PProjection>> sortDesc;

    public QuerySortImpl(){
        sortAsc = new ArrayList<>();
        sortDesc = new ArrayList<>();
    }

    public void addAsc(Function<R, PProjection> asc) {
        sortAsc.add(asc);
    }

    public void addDesc(Function<R, PProjection> desc) {
        sortDesc.add(desc);
    }

    public List<PProjection> applyAsc(R instance) {
        return sortAsc.stream()
                .map(s -> s.apply(instance))
                .collect(toList());
    }

    public List<PProjection> applyDesc(R instance) {
        return sortDesc.stream()
                .map(s -> s.apply(instance))
                .collect(toList());
    }
}
