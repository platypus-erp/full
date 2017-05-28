package org.platypus.api.query.impl;

import org.platypus.api.Record;
import org.platypus.api.annotations.doc.InternalUse;
import org.platypus.api.annotations.doc.ShouldBeInject;
import org.platypus.api.query.QuerySort;
import org.platypus.api.query.projection.PProjection;

import javax.annotation.PostConstruct;

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
@ShouldBeInject(QuerySort.class)
public class QuerySortImpl<R extends Record> implements QuerySort<R>{
    List<Function<R, PProjection>> sortAsc;
    List<Function<R, PProjection>> sortDesc;

    @PostConstruct
    void postConstruct(){
        sortAsc = new ArrayList<>();
        sortDesc = new ArrayList<>();
    }

    @Override
    public void addAsc(Function<R, PProjection> asc) {
        sortAsc.add(asc);
    }

    @Override
    public void addDesc(Function<R, PProjection> desc) {
        sortDesc.add(desc);
    }

    @Override
    public List<PProjection> applyAsc(R instance) {
        return sortAsc.stream()
                .map(s -> s.apply(instance))
                .collect(toList());
    }

    @Override
    public List<PProjection> applyDesc(R instance) {
        return sortDesc.stream()
                .map(s -> s.apply(instance))
                .collect(toList());
    }
}
