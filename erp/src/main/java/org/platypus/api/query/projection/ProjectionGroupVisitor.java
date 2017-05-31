package org.platypus.api.query.projection;

import org.platypus.api.query.VisitorInitializer;
import org.platypus.api.query.projection.visitor.field.agg.AvgAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.ConcatAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.CountAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.MaxAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.MinAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.SumAggProjection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface ProjectionGroupVisitor<INIT extends VisitorInitializer> extends ProjectionVisitor<INIT>{

    void visit(ConcatAggProjection stringConcatProjection);

    void visit(MaxAggProjection maxAggProjection);

    void visit(SumAggProjection sumAggProjection);

    void visit(MinAggProjection minAggProjection);

    void visit(CountAggProjection countAggProjection);

    void visit(AvgAggProjection avgAggProjection);
}
