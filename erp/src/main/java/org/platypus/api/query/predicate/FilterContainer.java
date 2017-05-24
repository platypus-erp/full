package org.platypus.api.query.predicate;

import org.platypus.api.PlatypusField;
import org.platypus.api.query.PredicateCombinator;

import java.util.function.Function;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/05/17.
 */
public class FilterContainer<T> {
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate1;
    public final PredicateCombinator combinator1;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate2;
    public final PredicateCombinator combinator2;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate3;
    public final PredicateCombinator combinator3;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate4;
    public final PredicateCombinator combinator4;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate5;
    public final PredicateCombinator combinator5;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate6;
    public final PredicateCombinator combinator6;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate7;
    public final PredicateCombinator combinator7;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate8;
    public final PredicateCombinator combinator8;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate9;
    public final PredicateCombinator combinator9;
    public final Function<T, QueryPredicate<? extends PlatypusField>> predicate10;

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1) {
        this(predicate1, null, null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2) {
        this(predicate1, combinator1, predicate2, null, null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3) {
        this(predicate1, combinator1, predicate2, combinator2, predicate3, null, null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3,
                           PredicateCombinator combinator3,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate4) {
        this(predicate1, combinator1,
                predicate2, combinator2,
                predicate3, combinator3,
                predicate4, null,
                null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3,
                           PredicateCombinator combinator3,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate4,
                           PredicateCombinator combinator4,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate5) {
        this(predicate1, combinator1,
                predicate2, combinator2,
                predicate3, combinator3,
                predicate4, combinator4,
                predicate5, null,
                null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3,
                           PredicateCombinator combinator3,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate4,
                           PredicateCombinator combinator4,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate5,
                           PredicateCombinator combinator5,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate6) {
        this(predicate1, combinator1,
                predicate2, combinator2,
                predicate3, combinator3,
                predicate4, combinator4,
                predicate5, combinator5,
                predicate6, null,
                null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3,
                           PredicateCombinator combinator3,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate4,
                           PredicateCombinator combinator4,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate5,
                           PredicateCombinator combinator5,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate6,
                           PredicateCombinator combinator6,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate7) {
        this(predicate1, combinator1,
                predicate2, combinator2,
                predicate3, combinator3,
                predicate4, combinator4,
                predicate5, combinator5,
                predicate6, combinator6,
                predicate7, null,
                null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3,
                           PredicateCombinator combinator3,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate4,
                           PredicateCombinator combinator4,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate5,
                           PredicateCombinator combinator5,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate6,
                           PredicateCombinator combinator6,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate7,
                           PredicateCombinator combinator7,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate8) {
        this(predicate1, combinator1,
                predicate2, combinator2,
                predicate3, combinator3,
                predicate4, combinator4,
                predicate5, combinator5,
                predicate6, combinator6,
                predicate7, combinator7,
                predicate8, null,
                null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1,
                           PredicateCombinator combinator1,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate2,
                           PredicateCombinator combinator2,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate3,
                           PredicateCombinator combinator3,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate4,
                           PredicateCombinator combinator4,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate5,
                           PredicateCombinator combinator5,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate6,
                           PredicateCombinator combinator6,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate7,
                           PredicateCombinator combinator7,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate8,
                           PredicateCombinator combinator8,
                           Function<T, QueryPredicate<? extends PlatypusField>> predicate9) {
        this(predicate1, combinator1,
                predicate2, combinator2,
                predicate3, combinator3,
                predicate4, combinator4,
                predicate5, combinator5,
                predicate6, combinator6,
                predicate7, combinator7,
                predicate8, combinator8,
                predicate9, null, null);
    }

    public FilterContainer(Function<T, QueryPredicate<? extends PlatypusField>> predicate1, PredicateCombinator combinator1, Function<T, QueryPredicate<? extends PlatypusField>> predicate2, PredicateCombinator combinator2, Function<T, QueryPredicate<? extends PlatypusField>> predicate3, PredicateCombinator combinator3, Function<T, QueryPredicate<? extends PlatypusField>> predicate4, PredicateCombinator combinator4, Function<T, QueryPredicate<? extends PlatypusField>> predicate5, PredicateCombinator combinator5, Function<T, QueryPredicate<? extends PlatypusField>> predicate6, PredicateCombinator combinator6, Function<T, QueryPredicate<? extends PlatypusField>> predicate7, PredicateCombinator combinator7, Function<T, QueryPredicate<? extends PlatypusField>> predicate8, PredicateCombinator combinator8, Function<T, QueryPredicate<? extends PlatypusField>> predicate9, PredicateCombinator combinator9, Function<T, QueryPredicate<? extends PlatypusField>> predicate10) {
        this.predicate1 = predicate1;
        this.combinator1 = combinator1;
        this.predicate2 = predicate2;
        this.combinator2 = combinator2;
        this.predicate3 = predicate3;
        this.combinator3 = combinator3;
        this.predicate4 = predicate4;
        this.combinator4 = combinator4;
        this.predicate5 = predicate5;
        this.combinator5 = combinator5;
        this.predicate6 = predicate6;
        this.combinator6 = combinator6;
        this.predicate7 = predicate7;
        this.combinator7 = combinator7;
        this.predicate8 = predicate8;
        this.combinator8 = combinator8;
        this.predicate9 = predicate9;
        this.combinator9 = combinator9;
        this.predicate10 = predicate10;
    }
}
