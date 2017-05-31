package org.platypus.api.query.projection;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.fields.StringField;
import org.platypus.api.query.projection.visitor.field.agg.AvgAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.ConcatAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.CountAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.MaxAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.MinAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.SumAggProjection;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 12/05/17.
 */
public class QueryAgregator<T extends Record> {

    public Function<T, PProjection> concat(Function<T, StringField> field, String separator){
        return r -> new ConcatAggProjection(field.apply(r), separator);
    }

    public Function<T, PProjection> max(Function<T, PlatypusField<?>> field){
        return r -> new MaxAggProjection(field.apply(r));
    }

    public Function<T, PProjection> min(Function<T, PlatypusField<?>> field){
        return r -> new MinAggProjection(field.apply(r));
    }

    public Function<T, PProjection> sum(Function<T, PlatypusField<?>> field){
        return r -> new SumAggProjection(field.apply(r));
    }

    public Function<T, PProjection> avg(Function<T, PlatypusField<?>> field){
        return r -> new AvgAggProjection(field.apply(r));
    }

    public Function<T, PProjection> count(Function<T, PlatypusField<?>> field){
        return r -> new CountAggProjection(field.apply(r));
    }
}
