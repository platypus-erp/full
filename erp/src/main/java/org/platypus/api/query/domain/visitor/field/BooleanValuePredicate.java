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
public class BooleanValuePredicate implements PPredicate<Boolean> {
    BooleanFieldPredicate field;
    boolean value;

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
        return value ? DomainPredicate.EQ : DomainPredicate.NOT_EQ;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
