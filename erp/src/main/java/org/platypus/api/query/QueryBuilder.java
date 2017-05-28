package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.annotations.doc.ShouldBeInject;
import org.platypus.api.query.domain.DomainBuilder;
import org.platypus.api.query.domain.DomainCombinator;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.impl.QueryFlagImpl;
import org.platypus.api.query.projection.PProjection;

import javax.inject.Inject;

import java.util.function.Function;

import static org.platypus.api.query.domain.DomainBuilder.NewDomain;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
@ShouldBeInject(SimpleQuery.class)
public class QueryBuilder<T extends Record> implements SimpleQuery<T> {


    private Function<T, PPredicate<?>> domain;
    @Inject
    private QueryProjection<T> projection;
    @Inject
    private QueryFlag queryFlag;


    @Override
    public SimpleQuery<T> distinct(boolean distinct) {
        queryFlag.distinct(distinct);
        return this;
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1) {
        projection.addProjection(field1);
        return this;
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2) {
        return get(field1).get(field2);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3) {
        return get(field1, field2).get(field3);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4) {
        return get(field1, field2, field3).get(field4);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4, Function<T, PProjection> field5) {
        return get(field1, field2, field3, field4).get(field5);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4, Function<T, PProjection> field5, Function<T, PProjection> field6) {
        return get(field1, field2, field3, field4, field5).get(field6);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4, Function<T, PProjection> field5, Function<T, PProjection> field6, Function<T, PProjection> field7) {
        return get(field1, field2, field3, field4, field5, field6).get(field7);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4, Function<T, PProjection> field5, Function<T, PProjection> field6, Function<T, PProjection> field7, Function<T, PProjection> field8) {
        return get(field1, field2, field3, field4, field5, field6, field7).get(field8);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4, Function<T, PProjection> field5, Function<T, PProjection> field6, Function<T, PProjection> field7, Function<T, PProjection> field8, Function<T, PProjection> field9) {
        return get(field1, field2, field3, field4, field5, field6, field7, field8).get(field9);
    }

    @Override
    public SimpleQuery<T> get(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3, Function<T, PProjection> field4, Function<T, PProjection> field5, Function<T, PProjection> field6, Function<T, PProjection> field7, Function<T, PProjection> field8, Function<T, PProjection> field9, Function<T, PProjection> field10) {
        return get(field1, field2, field3, field4, field5, field6, field7, field8, field9).get(field10);
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate) {
        domain = predicate;
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator, Function<T, PPredicate<?>> predicate2) {
        domain = NewDomain(predicate1, combinator, predicate2);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7, DomainCombinator combinator7, Function<T, PPredicate<?>> predicate8) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7, DomainCombinator combinator7, Function<T, PPredicate<?>> predicate8, DomainCombinator combinator8, Function<T, PPredicate<?>> predicate9) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8, combinator8, predicate9);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7, DomainCombinator combinator7, Function<T, PPredicate<?>> predicate8, DomainCombinator combinator8, Function<T, PPredicate<?>> predicate9, DomainCombinator combinator9, Function<T, PPredicate<?>> predicate10) {
        domain = NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8, combinator8, predicate9, combinator9, predicate10);
        return this;
    }

    @Override
    public SimpleQuery<T> limit(int limit) {
        queryFlag.limit(limit);
        return this;
    }

    @Override
    public SimpleQuery<T> page(int pageNumber, int pageSize) {
        queryFlag.page(pageNumber);
        queryFlag.pageSize(pageSize);
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(Function<T, PProjection> field1) {
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(Function<T, PProjection> field1, Function<T, PProjection> field2) {
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3) {
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(Function<T, PProjection> field1) {
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(Function<T, PProjection> field1, Function<T, PProjection> field2) {
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3) {
        return this;
    }
}
