package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.StringFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class StringValuePredicate implements PPredicate {

    StringFieldPredicate field;
    String value;
    DomainPredicate predicate;
    Collection<String> valuesIn;

    public StringValuePredicate(StringFieldPredicate field, DomainPredicate predicate, String value) {
        this.field = field;
        this.value = value;
        this.predicate = predicate;
    }

    public StringValuePredicate(StringFieldPredicate field, DomainPredicate predicate, Collection<String> valuesIn) {
        this.field = field;
        this.valuesIn = valuesIn;
    }

    public StringFieldPredicate getField() {
        return field;
    }

    public String getValue() {
        return value;
    }

    public DomainPredicate getCondition() {
        return predicate;
    }

    public Collection<String> getValuesIn() {
        return valuesIn;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
