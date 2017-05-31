package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.DateTimeFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.time.LocalDateTime;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DateTimeValuePredicate implements PPredicate<LocalDateTime> {

    DateTimeFieldPredicate field;
    DomainPredicate sqlPredicate;
    LocalDateTime value;
    LocalDateTime value2;

    public DateTimeValuePredicate(DateTimeFieldPredicate field, DomainPredicate sqlPredicate, LocalDateTime value, LocalDateTime value2) {
        this.field = field;
        this.sqlPredicate = sqlPredicate;
        this.value = value;
        this.value2 = value2;
    }

    public DateTimeFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return sqlPredicate;
    }

    public LocalDateTime getValue() {
        return value;
    }

    public LocalDateTime getValue2() {
        return value2;
    }



    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
