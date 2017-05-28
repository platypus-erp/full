package org.platypus.api.query.domain;

import org.platypus.api.Record;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.domain.Domain;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public final class DomainBuilder {

    private DomainBuilder() {
    }

    public static <R extends Record>
    Function<R, PPredicate<?>>
    NewDomain(Function<R, PPredicate<?>> predicate) {
        return predicate;
    }

    public static <R extends Record>
    Function<R, PPredicate<?>>
    NewDomain(Function<R, PPredicate<?>> predicate1,
              DomainCombinator combinator,
              Function<R, PPredicate<?>> predicate2) {
        return r -> new Domain<>(predicate1.apply(r), combinator, predicate2.apply(r));

    }


    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4,
                                      DomainCombinator combinator4,
                                      Function<R, PPredicate<?>> predicate5) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r),
                combinator4,
                predicate5.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4,
                                      DomainCombinator combinator4,
                                      Function<R, PPredicate<?>> predicate5,
                                      DomainCombinator combinator5,
                                      Function<R, PPredicate<?>> predicate6) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r),
                combinator4,
                predicate5.apply(r),
                combinator5,
                predicate6.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4,
                                      DomainCombinator combinator4,
                                      Function<R, PPredicate<?>> predicate5,
                                      DomainCombinator combinator5,
                                      Function<R, PPredicate<?>> predicate6,
                                      DomainCombinator combinator6,
                                      Function<R, PPredicate<?>> predicate7) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r),
                combinator4,
                predicate5.apply(r),
                combinator5,
                predicate6.apply(r),
                combinator6,
                predicate7.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4,
                                      DomainCombinator combinator4,
                                      Function<R, PPredicate<?>> predicate5,
                                      DomainCombinator combinator5,
                                      Function<R, PPredicate<?>> predicate6,
                                      DomainCombinator combinator6,
                                      Function<R, PPredicate<?>> predicate7,
                                      DomainCombinator combinator7,
                                      Function<R, PPredicate<?>> predicate8) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r),
                combinator4,
                predicate5.apply(r),
                combinator5,
                predicate6.apply(r),
                combinator6,
                predicate7.apply(r),
                combinator7,
                predicate8.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4,
                                      DomainCombinator combinator4,
                                      Function<R, PPredicate<?>> predicate5,
                                      DomainCombinator combinator5,
                                      Function<R, PPredicate<?>> predicate6,
                                      DomainCombinator combinator6,
                                      Function<R, PPredicate<?>> predicate7,
                                      DomainCombinator combinator7,
                                      Function<R, PPredicate<?>> predicate8,
                                      DomainCombinator combinator8,
                                      Function<R, PPredicate<?>> predicate9) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r),
                combinator4,
                predicate5.apply(r),
                combinator5,
                predicate6.apply(r),
                combinator6,
                predicate7.apply(r),
                combinator7,
                predicate8.apply(r),
                combinator8,
                predicate9.apply(r)
        );
    }

    public static <R extends Record>
    Function<R, PPredicate<?>> NewDomain(Function<R, PPredicate<?>> predicate1,
                                      DomainCombinator combinator1,
                                      Function<R, PPredicate<?>> predicate2,
                                      DomainCombinator combinator2,
                                      Function<R, PPredicate<?>> predicate3,
                                      DomainCombinator combinator3,
                                      Function<R, PPredicate<?>> predicate4,
                                      DomainCombinator combinator4,
                                      Function<R, PPredicate<?>> predicate5,
                                      DomainCombinator combinator5,
                                      Function<R, PPredicate<?>> predicate6,
                                      DomainCombinator combinator6,
                                      Function<R, PPredicate<?>> predicate7,
                                      DomainCombinator combinator7,
                                      Function<R, PPredicate<?>> predicate8,
                                      DomainCombinator combinator8,
                                      Function<R, PPredicate<?>> predicate9,
                                      DomainCombinator combinator9,
                                      Function<R, PPredicate<?>> predicate10) {
        return r -> new Domain<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r),
                combinator4,
                predicate5.apply(r),
                combinator5,
                predicate6.apply(r),
                combinator6,
                predicate7.apply(r),
                combinator7,
                predicate8.apply(r),
                combinator8,
                predicate9.apply(r),
                combinator9,
                predicate10.apply(r)
        );
    }
}
