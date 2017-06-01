package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.LongFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class LongValuePredicate implements PPredicate {
    LongFieldPredicate field;
    DomainPredicate condition;
    Long value;
    Long value2;
    Collection<Long> valuesIn;
    private boolean not;
    private boolean orNull;

    public LongValuePredicate(LongFieldPredicate field, DomainPredicate condition, Collection<Long> valuesIn) {
        this.field = field;
        this.condition = condition;
        this.valuesIn = valuesIn;
    }

    public LongValuePredicate(LongFieldPredicate field, DomainPredicate condition, Long value2) {
        this.field = field;
        this.condition = condition;
        this.value2 = value2;
    }
    public Collection<Long> getValuesIn() {
        return valuesIn;
    }

    public LongFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }

    public Long getValue() {
        return value;
    }
    public Long getValue2() {
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
