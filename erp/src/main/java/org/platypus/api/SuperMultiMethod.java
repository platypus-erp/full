package org.platypus.api;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/05/17.
 */
@FunctionalInterface
public interface SuperMultiMethod<R extends Record> {

    R callSuper(List<R> record);


}
