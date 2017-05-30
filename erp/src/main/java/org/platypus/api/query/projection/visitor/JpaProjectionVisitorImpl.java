package org.platypus.api.query.projection.visitor;

import org.platypus.api.query.QueryPath;
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
import org.platypus.erp.manager.impl.PlatypusToJpa;

import javax.persistence.criteria.CriteriaBuilder;
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
public class JpaProjectionVisitorImpl implements ProjectionVisitor<JpaProjectionInitializer> {
    List<Selection<?>> select = new ArrayList<>();
    Map<String, From<?, ?>> tableJoin;
    From<?, ?> root;
    CriteriaBuilder cb;

    @Override
    public void initWith(JpaProjectionInitializer initializer) {
        this.tableJoin = initializer.tableJoin;
        this.root = initializer.root;
        this.cb = initializer.cb;
    }

    @Override
    public void visit(BinaryProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(BigStringProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(BooleanProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(DateTimeProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(DateProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(DecimalProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(FloatProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(IntProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(LongProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(StringProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    @Override
    public void visit(TimeProjection element) {
        QueryPath path = element.getField().getPath();
        From<?, ?> from = PlatypusToJpa.getJoin(path, tableJoin, root);
        select.add(from.get(path.columnName).alias(path.getAliasColumn()));
    }

    public List<Selection<?>> getSelect() {
        return select;
    }
}
