package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;

import java.util.function.Function;

public class SortField<T  extends Record> {
    final Function<T, ? extends PlatypusField> field;
    final boolean asc;

    public SortField(Function<T, ? extends PlatypusField> field,boolean asc) {
        this.field = field;
        this.asc = asc;
    }
}