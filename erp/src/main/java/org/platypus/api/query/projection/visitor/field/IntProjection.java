package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.fields.IntField;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class IntProjection extends AbstractFieldProjection<IntProjection, IntField>{

    public IntProjection(IntField field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
