package org.platypus.api.query.impl;

import org.platypus.api.query.QueryPath;

import javax.persistence.criteria.From;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class PlatypusToJpa {


    public static From<?, ?> getJoin(QueryPath path, Map<String, From<?, ?>> tableJoin, From<?, ?> from) {
        From<?, ?> j = tableJoin.get(path.getTablePath());
        if (j == null) {
            j = from.join(path.columnName);
            tableJoin.putIfAbsent(path.getTablePath(), j);
        }
        if (path.isRelation && path.next != null) {
            j = getJoin(path.next, tableJoin, j);
        }
        return j;
    }
}
