package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.ProjectionGroupVisitor;
import org.platypus.api.query.projection.ProjectionVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public abstract class AbstractFieldProjection<T extends AbstractFieldProjection<T, F>, F extends PlatypusField<?>>
        implements PProjection{
    F field;

    public AbstractFieldProjection(F field) {
        this.field = field;
    }

    public F getField() {
        return field;
    }

    @Override
    public void accept(ProjectionGroupVisitor<?> predicateVisitor) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void accept(ProjectionVisitor<?> predicateVisitor) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
