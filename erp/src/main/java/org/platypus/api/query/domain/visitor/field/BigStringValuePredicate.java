package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.BigStringFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class BigStringValuePredicate implements PPredicate<String> {
    BigStringFieldPredicate field;
    DomainPredicate condition;

    public BigStringValuePredicate(BigStringFieldPredicate field, DomainPredicate condition) {
        this.field = field;
        this.condition = condition;
    }

    public BigStringFieldPredicate getField() {
        return field;
    }

    public DomainPredicate getCondition() {
        return condition;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
