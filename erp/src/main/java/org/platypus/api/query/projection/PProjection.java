package org.platypus.api.query.projection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface PProjection extends PProjectionGroup{

    void accept(ProjectionVisitor<?> predicateVisitor);

    @Override
    default void accept(ProjectionGroupVisitor<?> predicateVisitor) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
