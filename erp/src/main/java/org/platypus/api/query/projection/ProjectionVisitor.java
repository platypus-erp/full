package org.platypus.api.query.projection;

import org.platypus.api.query.VisitorInitializer;
import org.platypus.api.query.projection.visitor.field.BigStringProjection;
import org.platypus.api.query.projection.visitor.field.BinaryProjection;
import org.platypus.api.query.projection.visitor.field.BooleanProjection;
import org.platypus.api.query.projection.visitor.field.DateProjection;
import org.platypus.api.query.projection.visitor.field.DateTimeProjection;
import org.platypus.api.query.projection.visitor.field.DecimalProjection;
import org.platypus.api.query.projection.visitor.field.FloatProjection;
import org.platypus.api.query.projection.visitor.field.IntProjection;
import org.platypus.api.query.projection.visitor.field.LongProjection;
import org.platypus.api.query.projection.visitor.field.StringProjection;
import org.platypus.api.query.projection.visitor.field.TimeProjection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public interface ProjectionVisitor<INIT extends VisitorInitializer> {

    void initWith(INIT init);

    void visit(BinaryProjection binaryProjection);

    void visit(BigStringProjection element);

    void visit(BooleanProjection booleanProjection);

    void visit(DateTimeProjection dateTimeProjection);

    void visit(DateProjection dateProjection);

    void visit(DecimalProjection decimalProjection);

    void visit(FloatProjection floatProjection);

    void visit(IntProjection intProjection);

    void visit(LongProjection longProjection);

    void visit(StringProjection stringProjection);

    void visit(TimeProjection timeProjection);
}
