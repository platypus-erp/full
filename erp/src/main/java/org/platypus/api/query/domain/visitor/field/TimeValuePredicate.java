package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.TimeFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.time.LocalTime;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class TimeValuePredicate implements PPredicate {

    TimeFieldPredicate field;
    DomainPredicate sqlPredicate;
    LocalTime value;
    LocalTime value2;
    private boolean not;
    private boolean orNull;

    public TimeValuePredicate(TimeFieldPredicate field, DomainPredicate sqlPredicate, LocalTime value, LocalTime value2) {
        this.field = field;
        this.sqlPredicate = sqlPredicate;
        this.value = value;
        this.value2 = value2;
    }

    public TimeFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return sqlPredicate;
    }

    public LocalTime getValue() {
        return value;
    }

    public LocalTime getValue2() {
        return value2;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }

    @Override
    public PPredicate not() {
        this.not = true;
        return this;
    }

    @Override
    public PPredicate orNull() {
        this.orNull = true;
        return this;
    }

    public boolean isNot() {
        return not;
    }
}
