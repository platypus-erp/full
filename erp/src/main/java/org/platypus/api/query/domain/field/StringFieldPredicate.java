package org.platypus.api.query.domain.field;

import org.platypus.api.Pathable;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface StringFieldPredicate extends Pathable, FieldPredicate<String>{
    
    PPredicate<String> eq(String value);

    PPredicate<String> notEq(String value);

    PPredicate<String> notEqOrNull(String value);

    PPredicate<String> eqOrNull(String value);

    PPredicate<String> iEq(String value);

    PPredicate<String> iNotEq(String value);

    PPredicate<String> iNotEqOrNull(String value);

    PPredicate<String> iEqOrNull(String value);

    PPredicate<String> iIn(Collection<? extends CharSequence> values);

    PPredicate<String> iIn(String... values);

    PPredicate<String> in(Collection<? extends CharSequence> values);

    PPredicate<String> in(String... values);

    PPredicate<String> iNotIn(Collection<? extends CharSequence> values);

    PPredicate<String> iNotIn(String... values);

    PPredicate<String> notIn(Collection<? extends CharSequence> values);

    PPredicate<String> notIn(String... values);

    PPredicate<String> startWith(String value);

    PPredicate<String> endWith(String value);

    PPredicate<String> contains(String value);

    PPredicate<String> iStartWith(String value);

    PPredicate<String> iEndWith(String value);

    PPredicate<String> iContains(String value);
}
