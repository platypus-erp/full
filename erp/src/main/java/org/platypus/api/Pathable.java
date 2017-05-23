package org.platypus.api;

import org.platypus.api.query.QueryPath;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public interface Pathable {

    QueryPath getPath();
    QueryPath resolve(QueryPath queryPath);

}
