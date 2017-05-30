package org.platypus.erp.manager.impl;

import org.platypus.api.Record;
import org.platypus.api.query.SimpleQuery;
import org.platypus.api.query.domain.DomainCombinator;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.projection.PProjection;

import java.util.List;
import java.util.function.Function;

import static org.platypus.api.query.domain.DomainBuilder.NewDomain;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SimpleQueryImpl<T extends Record> implements SimpleQuery<T> {

    private final Class<T> aClass;
    private Function<T, PPredicate<?>> domain;
    private final QueryProjectionImpl<T> projection;
    private final QueryFlagImpl queryFlag;
    private final QuerySortImpl<T> querySort;

    public SimpleQueryImpl(Class<T> aClass) {
        this.aClass = aClass;
        this.projection = new QueryProjectionImpl<>();
        this.queryFlag = new QueryFlagImpl();
        this.querySort = new QuerySortImpl<>();
    }

    public Class<T> getTypeClass() {
        return aClass;
    }

    public List<PProjection> getProjection(T instance){
        return projection.apply(instance);
    }

    public boolean getAllField(){
        return projection.isEmpty();
    }

    public PPredicate<?> getPredicate(T instance){
        return domain.apply(instance);
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
        domain = and(predicate);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator, Function<T, PPredicate<?>> predicate2) {
        domain = and(NewDomain(predicate1, combinator, predicate2));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7, DomainCombinator combinator7, Function<T, PPredicate<?>> predicate8) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7, DomainCombinator combinator7, Function<T, PPredicate<?>> predicate8, DomainCombinator combinator8, Function<T, PPredicate<?>> predicate9) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8, combinator8, predicate9));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Function<T, PPredicate<?>> predicate1, DomainCombinator combinator1, Function<T, PPredicate<?>> predicate2, DomainCombinator combinator2, Function<T, PPredicate<?>> predicate3, DomainCombinator combinator3, Function<T, PPredicate<?>> predicate4, DomainCombinator combinator4, Function<T, PPredicate<?>> predicate5, DomainCombinator combinator5, Function<T, PPredicate<?>> predicate6, DomainCombinator combinator6, Function<T, PPredicate<?>> predicate7, DomainCombinator combinator7, Function<T, PPredicate<?>> predicate8, DomainCombinator combinator8, Function<T, PPredicate<?>> predicate9, DomainCombinator combinator9, Function<T, PPredicate<?>> predicate10) {
        domain = and(NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8, combinator8, predicate9, combinator9, predicate10));
        return this;
    }

    private Function<T, PPredicate<?>> and(Function<T, PPredicate<?>> domain){
        return this.domain == null ? domain : NewDomain(this.domain, DomainCombinator.AND, domain);
    }

    public SimpleQuery<T> limit(int limit) {
        queryFlag.limit(limit);
        return this;
    }

    public SimpleQuery<T> page(int pageNumber, int pageSize) {
        queryFlag.page(pageNumber);
        queryFlag.pageSize(pageSize);
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(Function<T, PProjection> field1) {
        querySort.addAsc(field1);
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(Function<T, PProjection> field1, Function<T, PProjection> field2) {
        querySort.addAsc(field1);
        querySort.addAsc(field2);
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3) {
        querySort.addAsc(field1);
        querySort.addAsc(field2);
        querySort.addAsc(field3);
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(Function<T, PProjection> field1) {
        querySort.addDesc(field1);
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(Function<T, PProjection> field1, Function<T, PProjection> field2) {
        querySort.addDesc(field1);
        querySort.addDesc(field2);
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(Function<T, PProjection> field1, Function<T, PProjection> field2, Function<T, PProjection> field3) {
        querySort.addDesc(field1);
        querySort.addDesc(field2);
        querySort.addDesc(field3);
        return this;
    }
}
