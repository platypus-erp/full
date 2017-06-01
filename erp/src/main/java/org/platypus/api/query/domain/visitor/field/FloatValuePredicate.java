package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.FloatFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class FloatValuePredicate implements PPredicate {
    FloatFieldPredicate field;
    DomainPredicate condition;
    Float value;
    Float value2;
    Collection<Float> valuesIn;
    private boolean not;
    private boolean orNull;

    public FloatValuePredicate(FloatFieldPredicate field, DomainPredicate condition, Collection<Float> valuesIn) {
        this.field = field;
        this.condition = condition;
        this.valuesIn = valuesIn;
    }

    public FloatValuePredicate(FloatFieldPredicate field, DomainPredicate condition, Float value, Float value2) {
        this.field = field;
        this.condition = condition;
        this.value = value;
        this.value2 = value2;
    }
    public Collection<Float> getValuesIn() {
        return valuesIn;
    }

    public FloatFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }

    public Float getValue() {
        return value;
    }
    public Float getValue2() {
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
