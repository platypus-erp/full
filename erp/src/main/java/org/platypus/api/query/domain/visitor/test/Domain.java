package org.platypus.api.query.domain.visitor.test;

import org.platypus.api.query.domain.DomainCombinator;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.field.StringFieldPredicate;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface Domain<T extends StringFieldPredicate> {
    Domain<T> filter(Function<T, PPredicate> predicate1,
                     DomainCombinator combinator1,
                     Function<T, PPredicate> predicate2,
                     DomainCombinator combinator2,
                     Function<T, PPredicate> predicate3,
                     DomainCombinator combinator3,
                     Function<T, PPredicate> predicate4);

    Domain<T> filter(Function<T, PPredicate> predicate1,
                     DomainCombinator combinator1,
                     Function<T, PPredicate> predicate2);

    static <T extends StringFieldPredicate> Function<T, PPredicate> GROUP(
            Function<T, PPredicate> predicate1,
            DomainCombinator combinator1,
            Function<T, PPredicate> predicate2) {
        return null;
    }


}
