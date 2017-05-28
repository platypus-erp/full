package org.platypus.api.query.projection.visitor.field;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.projection.PProjection;

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


}
