package org.platypus.api.query;

import org.platypus.api.Record;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface SimpleQueryFactory<R extends Record>{

    SimpleQuery<R> of(Class<R> rClass);
}
