package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.fields.DateField;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DateProjection extends AbstractFieldProjection<DateProjection, DateField>{
    public DateProjection(DateField field) {
        super(field);
    }

    @Override
    public void accept(ProjectionVisitor projectionVisitor) {
        projectionVisitor.visit(this);
    }
}
