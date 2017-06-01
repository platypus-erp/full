package org.platypus.api.query.domain.visitor.domain;

import org.platypus.api.Record;
import org.platypus.api.query.Domain;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class DomainContainer<T extends Record> implements PPredicate {
    PPredicate predicate1;
    Domain.DomainCombinator combinator1;
    PPredicate predicate2;
    Domain.DomainCombinator combinator2;
    PPredicate predicate3;
    Domain.DomainCombinator combinator3;
    PPredicate predicate4;
    Domain.DomainCombinator combinator4;
    PPredicate predicate5;
    Domain.DomainCombinator combinator5;
    PPredicate predicate6;
    Domain.DomainCombinator combinator6;
    PPredicate predicate7;
    Domain.DomainCombinator combinator7;
    PPredicate predicate8;
    Domain.DomainCombinator combinator8;
    PPredicate predicate9;
    Domain.DomainCombinator combinator9;
    PPredicate predicate10;
    Domain.DomainCombinator combinator10;
    PPredicate predicate11;
    Domain.DomainCombinator combinator11;
    PPredicate predicate12;
    Domain.DomainCombinator combinator12;
    PPredicate predicate13;
    Domain.DomainCombinator combinator13;
    PPredicate predicate14;
    Domain.DomainCombinator combinator14;
    PPredicate predicate15;
    Domain.DomainCombinator combinator15;
    PPredicate predicate16;
    Domain.DomainCombinator combinator16;
    PPredicate predicate17;
    Domain.DomainCombinator combinator17;
    PPredicate predicate18;
    Domain.DomainCombinator combinator18;
    PPredicate predicate19;
    Domain.DomainCombinator combinator19;
    PPredicate predicate20;
    boolean not;

    @Override
    public PPredicate not() {
        this.not = true;
        return this;
    }

    @Override
    public PPredicate orNull() {
        predicate1 = predicate1.orNull();
        predicate2 = predicate2.orNull();
        predicate3 = predicate3.orNull();
        predicate4 = predicate4.orNull();
        predicate5 = predicate5.orNull();
        predicate6 = predicate6.orNull();
        predicate7 = predicate7.orNull();
        predicate8 = predicate8.orNull();
        predicate9 = predicate9.orNull();
        predicate10 = predicate10.orNull();
        predicate11 = predicate11.orNull();
        predicate12 = predicate12.orNull();
        predicate13 = predicate13.orNull();
        predicate14 = predicate14.orNull();
        predicate15 = predicate15.orNull();
        predicate16 = predicate16.orNull();
        predicate17 = predicate17.orNull();
        predicate18 = predicate18.orNull();
        predicate19 = predicate19.orNull();
        predicate20 = predicate20.orNull();
        return this;
    }

    public DomainContainer(PPredicate predicate1) {
        this.predicate1 = predicate1;
    }

    //<editor-fold desc="Over load of constructor">
    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator combinator1,
                           PPredicate predicate2) {
        this.predicate1 = predicate1;
        this.combinator1 = combinator1;
        this.predicate2 = predicate2;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3) {
        this.predicate1 = predicate1;
        this.combinator1 = combinator1;
        this.predicate2 = predicate2;
        this.combinator2 = combinator2;
        this.predicate3 = predicate3;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4) {
        this.predicate1 = predicate1;
        this.combinator1 = combinator1;
        this.predicate2 = predicate2;
        this.combinator2 = combinator2;
        this.predicate3 = predicate3;
        this.combinator3 = combinator3;
        this.predicate4 = predicate4;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5) {
        this.predicate1 = predicate1;
        this.combinator1 = combinator1;
        this.predicate2 = predicate2;
        this.combinator2 = combinator2;
        this.predicate3 = predicate3;
        this.combinator3 = combinator3;
        this.predicate4 = predicate4;
        this.combinator4 = combinator4;
        this.predicate5 = predicate5;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6) {
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
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7) {
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
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8) {
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
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9) {
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
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10) {
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

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14, Domain.DomainCombinator  combinator14,
                           PPredicate predicate15) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
        this.combinator14 = combinator14;
        this.predicate15 = predicate15;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14, Domain.DomainCombinator  combinator14,
                           PPredicate predicate15, Domain.DomainCombinator  combinator15,
                           PPredicate predicate16) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
        this.combinator14 = combinator14;
        this.predicate15 = predicate15;
        this.combinator15 = combinator15;
        this.predicate16 = predicate16;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14, Domain.DomainCombinator  combinator14,
                           PPredicate predicate15, Domain.DomainCombinator  combinator15,
                           PPredicate predicate16, Domain.DomainCombinator  combinator16,
                           PPredicate predicate17) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
        this.combinator14 = combinator14;
        this.predicate15 = predicate15;
        this.combinator15 = combinator15;
        this.predicate16 = predicate16;
        this.combinator16 = combinator16;
        this.predicate17 = predicate17;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14, Domain.DomainCombinator  combinator14,
                           PPredicate predicate15, Domain.DomainCombinator  combinator15,
                           PPredicate predicate16, Domain.DomainCombinator  combinator16,
                           PPredicate predicate17, Domain.DomainCombinator  combinator17,
                           PPredicate predicate18) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
        this.combinator14 = combinator14;
        this.predicate15 = predicate15;
        this.combinator15 = combinator15;
        this.predicate16 = predicate16;
        this.combinator16 = combinator16;
        this.predicate17 = predicate17;
        this.combinator17 = combinator17;
        this.predicate18 = predicate18;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14, Domain.DomainCombinator  combinator14,
                           PPredicate predicate15, Domain.DomainCombinator  combinator15,
                           PPredicate predicate16, Domain.DomainCombinator  combinator16,
                           PPredicate predicate17, Domain.DomainCombinator  combinator17,
                           PPredicate predicate18, Domain.DomainCombinator  combinator18,
                           PPredicate predicate19) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
        this.combinator14 = combinator14;
        this.predicate15 = predicate15;
        this.combinator15 = combinator15;
        this.predicate16 = predicate16;
        this.combinator16 = combinator16;
        this.predicate17 = predicate17;
        this.combinator17 = combinator17;
        this.predicate18 = predicate18;
        this.combinator18 = combinator18;
        this.predicate19 = predicate19;
    }

    public DomainContainer(PPredicate predicate1, Domain.DomainCombinator  combinator1,
                           PPredicate predicate2, Domain.DomainCombinator  combinator2,
                           PPredicate predicate3, Domain.DomainCombinator  combinator3,
                           PPredicate predicate4, Domain.DomainCombinator  combinator4,
                           PPredicate predicate5, Domain.DomainCombinator  combinator5,
                           PPredicate predicate6, Domain.DomainCombinator  combinator6,
                           PPredicate predicate7, Domain.DomainCombinator  combinator7,
                           PPredicate predicate8, Domain.DomainCombinator  combinator8,
                           PPredicate predicate9, Domain.DomainCombinator  combinator9,
                           PPredicate predicate10, Domain.DomainCombinator  combinator10,
                           PPredicate predicate11, Domain.DomainCombinator  combinator11,
                           PPredicate predicate12, Domain.DomainCombinator  combinator12,
                           PPredicate predicate13, Domain.DomainCombinator  combinator13,
                           PPredicate predicate14, Domain.DomainCombinator  combinator14,
                           PPredicate predicate15, Domain.DomainCombinator  combinator15,
                           PPredicate predicate16, Domain.DomainCombinator  combinator16,
                           PPredicate predicate17, Domain.DomainCombinator  combinator17,
                           PPredicate predicate18, Domain.DomainCombinator  combinator18,
                           PPredicate predicate19, Domain.DomainCombinator  combinator19,
                           PPredicate predicate20) {
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
        this.combinator10 = combinator10;
        this.predicate11 = predicate11;
        this.combinator11 = combinator11;
        this.predicate12 = predicate12;
        this.combinator12 = combinator12;
        this.predicate13 = predicate13;
        this.combinator13 = combinator13;
        this.predicate14 = predicate14;
        this.combinator14 = combinator14;
        this.predicate15 = predicate15;
        this.combinator15 = combinator15;
        this.predicate16 = predicate16;
        this.combinator16 = combinator16;
        this.predicate17 = predicate17;
        this.combinator17 = combinator17;
        this.predicate18 = predicate18;
        this.combinator18 = combinator18;
        this.predicate19 = predicate19;
        this.combinator19 = combinator19;
        this.predicate20 = predicate20;
    }
    //</editor-fold>


    public Optional<PPredicate> getPredicate1() {
        return Optional.ofNullable(predicate1);
    }

    public Optional<Domain.DomainCombinator> getCombinator1() {
        return Optional.ofNullable(combinator1);
    }

    public Optional<PPredicate> getPredicate2() {
        return Optional.ofNullable(predicate2);
    }

    public Optional<Domain.DomainCombinator> getCombinator2() {
        return Optional.ofNullable(combinator2);
    }

    public Optional<PPredicate> getPredicate3() {
        return Optional.ofNullable(predicate3);
    }

    public Optional<Domain.DomainCombinator> getCombinator3() {
        return Optional.ofNullable(combinator3);
    }

    public Optional<PPredicate> getPredicate4() {
        return Optional.ofNullable(predicate4);
    }

    public Optional<Domain.DomainCombinator> getCombinator4() {
        return Optional.ofNullable(combinator4);
    }

    public Optional<PPredicate> getPredicate5() {
        return Optional.ofNullable(predicate5);
    }

    public Optional<Domain.DomainCombinator> getCombinator5() {
        return Optional.ofNullable(combinator5);
    }

    public Optional<PPredicate> getPredicate6() {
        return Optional.ofNullable(predicate6);
    }

    public Optional<Domain.DomainCombinator> getCombinator6() {
        return Optional.ofNullable(combinator6);
    }

    public Optional<PPredicate> getPredicate7() {
        return Optional.ofNullable(predicate7);
    }

    public Optional<Domain.DomainCombinator> getCombinator7() {
        return Optional.ofNullable(combinator7);
    }

    public Optional<PPredicate> getPredicate8() {
        return Optional.ofNullable(predicate8);
    }

    public Optional<Domain.DomainCombinator> getCombinator8() {
        return Optional.ofNullable(combinator8);
    }

    public Optional<PPredicate> getPredicate9() {
        return Optional.ofNullable(predicate9);
    }

    public Optional<Domain.DomainCombinator> getCombinator9() {
        return Optional.ofNullable(combinator9);
    }

    public Optional<PPredicate> getPredicate10() {
        return Optional.ofNullable(predicate10);
    }

    public Optional<Domain.DomainCombinator> getCombinator10() {
        return Optional.ofNullable(combinator10);
    }

    public Optional<PPredicate> getPredicate11() {
        return Optional.ofNullable(predicate11);
    }

    public Optional<Domain.DomainCombinator> getCombinator11() {
        return Optional.ofNullable(combinator11);
    }

    public Optional<PPredicate> getPredicate12() {
        return Optional.ofNullable(predicate12);
    }

    public Optional<Domain.DomainCombinator> getCombinator12() {
        return Optional.ofNullable(combinator12);
    }

    public Optional<PPredicate> getPredicate13() {
        return Optional.ofNullable(predicate13);
    }

    public Optional<Domain.DomainCombinator> getCombinator13() {
        return Optional.ofNullable(combinator13);
    }

    public Optional<PPredicate> getPredicate14() {
        return Optional.ofNullable(predicate14);
    }

    public Optional<Domain.DomainCombinator> getCombinator14() {
        return Optional.ofNullable(combinator14);
    }

    public Optional<PPredicate> getPredicate15() {
        return Optional.ofNullable(predicate15);
    }

    public Optional<Domain.DomainCombinator> getCombinator15() {
        return Optional.ofNullable(combinator15);
    }

    public Optional<PPredicate> getPredicate16() {
        return Optional.ofNullable(predicate16);
    }

    public Optional<Domain.DomainCombinator> getCombinator16() {
        return Optional.ofNullable(combinator16);
    }

    public Optional<PPredicate> getPredicate17() {
        return Optional.ofNullable(predicate17);
    }

    public Optional<Domain.DomainCombinator> getCombinator17() {
        return Optional.ofNullable(combinator17);
    }

    public Optional<PPredicate> getPredicate18() {
        return Optional.ofNullable(predicate18);
    }

    public Optional<Domain.DomainCombinator> getCombinator18() {
        return Optional.ofNullable(combinator18);
    }

    public Optional<PPredicate> getPredicate19() {
        return Optional.ofNullable(predicate19);
    }

    public Optional<Domain.DomainCombinator> getCombinator19() {
        return Optional.ofNullable(combinator19);
    }

    public Optional<PPredicate> getPredicate20() {
        return Optional.ofNullable(predicate20);
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
