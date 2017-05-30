package org.platypus.api.query.projection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface PProjectionGroup {

    void accept(ProjectionGroupVisitor<?> predicateVisitor);
}
