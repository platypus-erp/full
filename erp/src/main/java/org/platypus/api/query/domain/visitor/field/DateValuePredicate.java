package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.field.DateFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;
import org.platypus.api.query.domain.DomainPredicate;

import java.time.LocalDate;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DateValuePredicate implements PPredicate {

    DateFieldPredicate field;
    DomainPredicate sqlPredicate;
    LocalDate value;
    LocalDate value2;

    public DateValuePredicate(DateFieldPredicate field, DomainPredicate sqlPredicate, LocalDate value, LocalDate value2) {
        this.field = field;
        this.sqlPredicate = sqlPredicate;
        this.value = value;
        this.value2 = value2;
    }

    public DateFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return sqlPredicate;
    }

    public LocalDate getValue() {
        return value;
    }

    public LocalDate getValue2() {
        return value2;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
