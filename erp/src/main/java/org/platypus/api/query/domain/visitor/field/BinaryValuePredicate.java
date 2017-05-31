package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.BinaryFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class BinaryValuePredicate implements PPredicate<byte[]> {
    BinaryFieldPredicate field;
    DomainPredicate condition;

    public BinaryValuePredicate(BinaryFieldPredicate field, DomainPredicate condition) {
        this.field = field;
        this.condition = condition;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }

    public BinaryFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }
}
