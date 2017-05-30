package org.platypus.api;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/05/17.
 */
@FunctionalInterface
public interface SuperMethod<R extends Record<R>> {

    R callSuper(R record);


}
