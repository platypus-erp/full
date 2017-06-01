package org.platypus.api.query.domain.field;

import org.platypus.api.Pathable;
import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.field.StringValuePredicate;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface StringFieldPredicate extends Pathable, FieldPredicate{

    @Override
    default PPredicate isNull() {
        return new StringValuePredicate(this, DomainPredicate.IS_NULL);
    }

    @Override
    default PPredicate isNotNull() {
        return new StringValuePredicate(this, DomainPredicate.IS_NOT_NULL);
    }

    default PPredicate eq(String value){
        return new StringValuePredicate(this, DomainPredicate.EQ, value);
    }

    default PPredicate iEq(String value){
        return new StringValuePredicate(this, DomainPredicate.I_EQ, value);
    }

    default PPredicate iIn(Collection<String> values) {
        return new StringValuePredicate(this, DomainPredicate.I_IN, values);
    }

    default PPredicate iIn(String... values) {
        return new StringValuePredicate(this, DomainPredicate.I_IN, Arrays.asList(values));
    }

    default PPredicate in(Collection<String> values){
        return new StringValuePredicate(this, DomainPredicate.I_IN, values);
    }

    default PPredicate in(String... values){
        return new StringValuePredicate(this, DomainPredicate.IN, Arrays.asList(values));
    }

    default PPredicate startWith(String value){
        return new StringValuePredicate(this, DomainPredicate.START_WITH, value);
    }

    default PPredicate endWith(String value){
        return new StringValuePredicate(this, DomainPredicate.END_WITH, value);
    }

    default PPredicate contains(String value){
        return new StringValuePredicate(this, DomainPredicate.CONTAINS, value);
    }

    default PPredicate iStartWith(String value){
        return new StringValuePredicate(this, DomainPredicate.I_START_WITH, value);
    }

    default PPredicate iEndWith(String value){
        return new StringValuePredicate(this, DomainPredicate.I_END_WITH, value);
    }

    default PPredicate iContains(String value){
        return new StringValuePredicate(this, DomainPredicate.I_CONTAINS, value);
    }
}
