package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.DecimalFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DecimalValuePredicate implements PPredicate {
    DecimalFieldPredicate field;
    DomainPredicate condition;
    BigDecimal value;
    BigDecimal value2;
    Collection<BigDecimal> valuesIn;

    public DecimalValuePredicate(DecimalFieldPredicate field, DomainPredicate condition, Collection<BigDecimal> valuesIn) {
        this.field = field;
        this.condition = condition;
        this.valuesIn = valuesIn;
    }

    public Collection<BigDecimal> getValuesIn() {
        return valuesIn;
    }

    public DecimalValuePredicate(DecimalFieldPredicate field, DomainPredicate condition, BigDecimal value1, BigDecimal value2) {
        this.field = field;
        this.condition = condition;
        this.value = value1;
        this.value2 = value2;
    }

    public DecimalFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }
    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getValue2() {
        return value2;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
