package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.domain.DomainContainer;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/05/17.
 */
@FunctionalInterface
public interface Domain<R extends Record> {

    PPredicate apply(R record);

    enum DomainCombinator {
        AND,
        OR
    }

    static <R extends Record> Domain<R> NewDomain(Domain<R> predicate) {
        return predicate;
    }

    //<editor-fold desc="Over load NewDomain Method">
    static <R extends Record>
    Domain<R>
    NewDomain(Domain<R> predicate1,
              DomainCombinator combinator,
              Domain<R> predicate2) {
        return r -> new DomainContainer<>(predicate1.apply(r), combinator, predicate2.apply(r));

    }

    static <R extends Record>
    Domain<R>
    Not(Domain<R> predicate1){
        return r -> predicate1.apply(r).not();
    }


    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3) {
        return r -> new DomainContainer<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r)
        );
    }

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4) {
        return r -> new DomainContainer<>(
                predicate1.apply(r),
                combinator1,
                predicate2.apply(r),
                combinator2,
                predicate3.apply(r),
                combinator3,
                predicate4.apply(r)
        );
    }

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4,
                        DomainCombinator combinator4,
                        Domain<R> predicate5) {
        return r -> new DomainContainer<>(
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

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4,
                        DomainCombinator combinator4,
                        Domain<R> predicate5,
                        DomainCombinator combinator5,
                        Domain<R> predicate6) {
        return r -> new DomainContainer<>(
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

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4,
                        DomainCombinator combinator4,
                        Domain<R> predicate5,
                        DomainCombinator combinator5,
                        Domain<R> predicate6,
                        DomainCombinator combinator6,
                        Domain<R> predicate7) {
        return r -> new DomainContainer<>(
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

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4,
                        DomainCombinator combinator4,
                        Domain<R> predicate5,
                        DomainCombinator combinator5,
                        Domain<R> predicate6,
                        DomainCombinator combinator6,
                        Domain<R> predicate7,
                        DomainCombinator combinator7,
                        Domain<R> predicate8) {
        return r -> new DomainContainer<>(
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

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4,
                        DomainCombinator combinator4,
                        Domain<R> predicate5,
                        DomainCombinator combinator5,
                        Domain<R> predicate6,
                        DomainCombinator combinator6,
                        Domain<R> predicate7,
                        DomainCombinator combinator7,
                        Domain<R> predicate8,
                        DomainCombinator combinator8,
                        Domain<R> predicate9) {
        return r -> new DomainContainer<>(
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

    static <R extends Record>
    Domain<R> NewDomain(Domain<R> predicate1,
                        DomainCombinator combinator1,
                        Domain<R> predicate2,
                        DomainCombinator combinator2,
                        Domain<R> predicate3,
                        DomainCombinator combinator3,
                        Domain<R> predicate4,
                        DomainCombinator combinator4,
                        Domain<R> predicate5,
                        DomainCombinator combinator5,
                        Domain<R> predicate6,
                        DomainCombinator combinator6,
                        Domain<R> predicate7,
                        DomainCombinator combinator7,
                        Domain<R> predicate8,
                        DomainCombinator combinator8,
                        Domain<R> predicate9,
                        DomainCombinator combinator9,
                        Domain<R> predicate10) {
        return r -> new DomainContainer<>(
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
    //</editor-fold>

}
