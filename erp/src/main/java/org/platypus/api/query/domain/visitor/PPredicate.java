package org.platypus.api.query.domain.visitor;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface PPredicate<T> extends Predicate<T> {

    void accept(PredicateVisitor predicateVisitor);

    @Override
    default boolean test(T test) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
