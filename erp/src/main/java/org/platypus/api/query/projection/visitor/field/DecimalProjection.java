package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.fields.DecimalField;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DecimalProjection extends AbstractFieldProjection<DecimalProjection, DecimalField>{
    public DecimalProjection(DecimalField field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
