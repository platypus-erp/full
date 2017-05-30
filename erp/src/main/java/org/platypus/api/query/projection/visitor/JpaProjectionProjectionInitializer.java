package org.platypus.api.query.projection.visitor;

import org.platypus.api.query.VisitorInitializer;

import javax.persistence.Tuple;

/**
 * @author chmuchme
 * @since 0.1
 * on 29/05/17.
 */
public class JpaProjectionProjectionInitializer implements VisitorInitializer{

    public final Tuple tuple;

    public JpaProjectionProjectionInitializer(Tuple tuple) {
        this.tuple = tuple;
    }
}
