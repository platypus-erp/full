package org.platypus.api;

import org.platypus.api.query.tmp.QueryPathImpl;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public interface SetPathable extends Pathable{

    void setPath(QueryPathImpl queryPath);

}
