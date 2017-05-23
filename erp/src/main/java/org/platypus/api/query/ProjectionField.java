package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;

import java.util.function.Function;

public class ProjectionField<T  extends Record> {
    final Function<T, ? extends PlatypusField> field;
    final SqlAggregator aggregator;
    final Object supValue;

    public ProjectionField(Function<T, ? extends PlatypusField> field, SqlAggregator aggregator) {
        this.field = field;
        this.aggregator = aggregator;
        this.supValue = null;
    }

    public ProjectionField(Function<T, ? extends PlatypusField> field, SqlAggregator aggregator, Object supValue) {
        this.field = field;
        this.aggregator = aggregator;
        this.supValue = supValue;
    }

    public ProjectionField(Function<T, ? extends PlatypusField> field) {
        this.field = field;
        this.aggregator = null;
        this.supValue = null;
    }

    public Function<T, ? extends PlatypusField> getField() {
        return field;
    }

    public SqlAggregator getAggregator() {
        return aggregator;
    }

    public Object getSupValue() {
        return supValue;
    }
}