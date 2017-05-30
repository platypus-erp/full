package org.platypus.api.query.projection.visitor;

import org.platypus.api.query.projection.ProjectionVisitor;
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

import javax.persistence.Tuple;
import javax.persistence.criteria.Selection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class JpaProjectionResolverVisitorImpl implements ProjectionVisitor<JpaProjectionProjectionInitializer> {
    Tuple tuple;

    @Override
    public void initWith(JpaProjectionProjectionInitializer initializer) {
        this.tuple = initializer.tuple;
    }

    @Override
    public void visit(BinaryProjection element) {
        byte[] value = tuple.get(element.getField().getPath().getAliasColumn(), byte[].class);
        element.getField().set(value);
    }

    @Override
    public void visit(BigStringProjection element) {
        String value = tuple.get(element.getField().getPath().getAliasColumn(), String.class);
        element.getField().set(value);
    }

    @Override
    public void visit(BooleanProjection element) {
        Boolean value = tuple.get(element.getField().getPath().getAliasColumn(), Boolean.class);
        element.getField().set(value);
    }

    @Override
    public void visit(DateTimeProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), LocalDateTime.class));
    }

    @Override
    public void visit(DateProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), LocalDate.class));
    }

    @Override
    public void visit(DecimalProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), BigDecimal.class));
    }

    @Override
    public void visit(FloatProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), Float.class));
    }

    @Override
    public void visit(IntProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), Integer.class));
    }

    @Override
    public void visit(LongProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), Long.class));
    }

    @Override
    public void visit(StringProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), String.class));
    }

    @Override
    public void visit(TimeProjection element) {
        element.getField().set(tuple.get(element.getField().getPath().getAliasColumn(), LocalTime.class));
    }
}
