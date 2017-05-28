package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.fields.DateTimeField;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DateTimeProjection extends AbstractFieldProjection<DateTimeProjection, DateTimeField>{

    public DateTimeProjection(DateTimeField field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
