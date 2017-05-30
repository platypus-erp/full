package org.platypus.api.query.projection.visitor;

import org.platypus.api.query.VisitorInitializer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 29/05/17.
 */
public class JpaProjectionInitializer implements VisitorInitializer{

    public final Map<String, From<?, ?>> tableJoin;
    public final From<?, ?> root;
    public final CriteriaBuilder cb;

    public JpaProjectionInitializer(Map<String, From<?, ?>> tableJoin, From<?, ?> root, CriteriaBuilder cb) {
        this.tableJoin = tableJoin;
        this.root = root;
        this.cb = cb;
    }
}
