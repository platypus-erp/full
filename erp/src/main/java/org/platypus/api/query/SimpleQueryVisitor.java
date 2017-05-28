package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.domain.visitor.domain.Domain;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface SimpleQueryVisitor<T extends Record> {


    void visit(QueryProjection<T> element);
    void visit(Domain<T> element);
    void visit(QuerySort<T> element);
    void visit(QueryPaginator<T> element);
}
