package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.domain.DomainCombinator;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.projection.PProjection;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface SimpleQueryFactory<R extends Record>{

    SimpleQuery<R> of(Class<R> rClass);
}
