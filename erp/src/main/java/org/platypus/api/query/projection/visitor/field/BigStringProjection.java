package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.fields.BigStringField;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class BigStringProjection extends AbstractFieldProjection<BigStringProjection, BigStringField>{
    public BigStringProjection(BigStringField field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
