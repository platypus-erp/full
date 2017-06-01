package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/05/17.
 */
@FunctionalInterface
public interface ProjectionGetter<R extends Record> {

    PlatypusField<?> apply(R record);

}
