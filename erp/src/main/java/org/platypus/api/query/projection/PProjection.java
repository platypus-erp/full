package org.platypus.api.query.projection;

import org.platypus.api.PlatypusField;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface PProjection extends PProjectionGroup{

    void accept(ProjectionVisitor<?> predicateVisitor);
}
