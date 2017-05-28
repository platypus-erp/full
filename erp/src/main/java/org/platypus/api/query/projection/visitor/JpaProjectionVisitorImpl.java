package org.platypus.api.query.projection.visitor;

import org.platypus.api.query.impl.PlatypusToJpa;
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
import org.platypus.api.query.projection.visitor.field.agg.AvgAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.ConcatAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.CountAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.MaxAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.MinAggProjection;
import org.platypus.api.query.projection.visitor.field.agg.SumAggProjection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class JpaProjectionVisitorImpl implements ProjectionVisitor{
    List<Selection<?>> select = new ArrayList<>();
    List<Expression<?>> selectNonAgregator = new ArrayList<>();
    List<Selection<?>> selectAggregator = new ArrayList<>();
    PlatypusToJpa p2j;
    Map<String, From<?, ?>> tableJoin;
    From<?, ?> root;
    CriteriaBuilder cb;

    @Override
    public void visit(BinaryProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(BigStringProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(BooleanProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(DateTimeProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(DateProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(DecimalProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(FloatProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(IntProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(LongProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(StringProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(TimeProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectNonAgregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(ConcatAggProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectAggregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(MaxAggProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectAggregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(SumAggProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectAggregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(MinAggProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectAggregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(CountAggProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectAggregator.add(from.get(element.getField().getPath().columnName));
    }

    @Override
    public void visit(AvgAggProjection element) {
        From<?, ?> from = PlatypusToJpa.getJoin(element.getField().getPath(), tableJoin, root);
//        select.add(from.get(binaryProjection.getField().getPath().columnName));
        selectAggregator.add(from.get(element.getField().getPath().columnName));
    }
}
