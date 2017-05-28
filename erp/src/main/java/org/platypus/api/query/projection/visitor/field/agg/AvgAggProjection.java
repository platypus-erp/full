package org.platypus.api.query.projection.visitor.field.agg;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.projection.ProjectionVisitor;
import org.platypus.api.query.projection.visitor.field.AbstractFieldProjection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class AvgAggProjection extends AbstractFieldProjection<AvgAggProjection, PlatypusField<?>> {
    public AvgAggProjection(PlatypusField<?> field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
