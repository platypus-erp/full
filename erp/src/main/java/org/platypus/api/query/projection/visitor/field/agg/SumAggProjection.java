package org.platypus.api.query.projection.visitor.field.agg;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.projection.visitor.field.AbstractFieldProjection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class SumAggProjection extends AbstractFieldProjection<SumAggProjection, PlatypusField<?>> {
    public SumAggProjection(PlatypusField<?> field) {
        super(field);
    }

}
