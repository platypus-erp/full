package org.platypus.api.query.predicate;

import org.platypus.api.Record;
import org.platypus.api.query.SqlPredicate;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface QueryPredicate<T> extends PlatypusPredicate<T, SqlPredicate, T>{

}
