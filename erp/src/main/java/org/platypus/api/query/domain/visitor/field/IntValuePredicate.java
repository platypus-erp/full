package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.IntFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class IntValuePredicate implements PPredicate {
    IntFieldPredicate field;
    DomainPredicate condition;
    Integer value;
    Integer value2;
    Collection<Integer> valuesIn;
    private boolean not;
    private boolean orNull;

    public IntValuePredicate(IntFieldPredicate field, DomainPredicate condition, Collection<Integer> valuesIn) {
        this.field = field;
        this.condition = condition;
        this.valuesIn = valuesIn;
    }

    public IntValuePredicate(IntFieldPredicate field, DomainPredicate condition, Integer value, Integer value2) {
        this.field = field;
        this.condition = condition;
        this.value = value;
        this.value2 = value2;
    }
    public Collection<Integer> getValuesIn() {
        return valuesIn;
    }

    public IntFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }

    public Integer getValue() {
        return value;
    }
    public Integer getValue2() {
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
