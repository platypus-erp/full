package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.BooleanFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class BooleanValuePredicate implements PPredicate {
    BooleanFieldPredicate field;
    boolean value;
    private boolean not;
    private boolean orNull;

    public static BooleanValuePredicate isTrue(BooleanFieldPredicate field){
        return new BooleanValuePredicate(field, true);
    }

    public static BooleanValuePredicate isFalse(BooleanFieldPredicate field){
        return new BooleanValuePredicate(field, true);
    }

    private BooleanValuePredicate(BooleanFieldPredicate field, boolean value) {
        this.field = field;
        this.value = value;
    }

    public BooleanFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return DomainPredicate.EQ;
    }

    public boolean getValue() {
        return value;
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
