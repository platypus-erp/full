package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.fields.BooleanField;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class BooleanProjection extends AbstractFieldProjection<BooleanProjection, BooleanField>{
    public BooleanProjection(BooleanField field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
