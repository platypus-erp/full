package org.platypus.erp.manager.impl;

import org.platypus.api.Record;
import org.platypus.api.query.Domain;
import org.platypus.api.query.Domain.DomainCombinator;
import org.platypus.api.query.ProjectionGetter;
import org.platypus.api.query.SimpleQuery;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.projection.PProjection;

import java.util.List;


/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SimpleQueryImpl<T extends Record> implements SimpleQuery<T> {

    private final Class<T> aClass;
    private Domain<T> domain;
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

    public PPredicate getPredicate(T instance){
        return domain.apply(instance);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1) {
        projection.addProjection(field1);
        return this;
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2) {
        return get(field1).get(field2);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3) {
        return get(field1, field2).get(field3);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4) {
        return get(field1, field2, field3).get(field4);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4, ProjectionGetter<T> field5) {
        return get(field1, field2, field3, field4).get(field5);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4, ProjectionGetter<T> field5, ProjectionGetter<T> field6) {
        return get(field1, field2, field3, field4, field5).get(field6);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4, ProjectionGetter<T> field5, ProjectionGetter<T> field6, ProjectionGetter<T> field7) {
        return get(field1, field2, field3, field4, field5, field6).get(field7);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4, ProjectionGetter<T> field5, ProjectionGetter<T> field6, ProjectionGetter<T> field7, ProjectionGetter<T> field8) {
        return get(field1, field2, field3, field4, field5, field6, field7).get(field8);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4, ProjectionGetter<T> field5, ProjectionGetter<T> field6, ProjectionGetter<T> field7, ProjectionGetter<T> field8, ProjectionGetter<T> field9) {
        return get(field1, field2, field3, field4, field5, field6, field7, field8).get(field9);
    }

    @Override
    public SimpleQuery<T> get(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3, ProjectionGetter<T> field4, ProjectionGetter<T> field5, ProjectionGetter<T> field6, ProjectionGetter<T> field7, ProjectionGetter<T> field8, ProjectionGetter<T> field9, ProjectionGetter<T> field10) {
        return get(field1, field2, field3, field4, field5, field6, field7, field8, field9).get(field10);
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate) {
        domain = and(predicate);
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator, Domain<T> predicate2) {
        domain = and(Domain.NewDomain(predicate1, combinator, predicate2));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4, DomainCombinator combinator4, Domain<T> predicate5) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4, DomainCombinator combinator4, Domain<T> predicate5, DomainCombinator combinator5, Domain<T> predicate6) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4, DomainCombinator combinator4, Domain<T> predicate5, DomainCombinator combinator5, Domain<T> predicate6, DomainCombinator combinator6, Domain<T> predicate7) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4, DomainCombinator combinator4, Domain<T> predicate5, DomainCombinator combinator5, Domain<T> predicate6, DomainCombinator combinator6, Domain<T> predicate7, DomainCombinator combinator7, Domain<T> predicate8) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4, DomainCombinator combinator4, Domain<T> predicate5, DomainCombinator combinator5, Domain<T> predicate6, DomainCombinator combinator6, Domain<T> predicate7, DomainCombinator combinator7, Domain<T> predicate8, DomainCombinator combinator8, Domain<T> predicate9) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8, combinator8, predicate9));
        return this;
    }

    @Override
    public SimpleQuery<T> filter(Domain<T> predicate1, DomainCombinator combinator1, Domain<T> predicate2, DomainCombinator combinator2, Domain<T> predicate3, DomainCombinator combinator3, Domain<T> predicate4, DomainCombinator combinator4, Domain<T> predicate5, DomainCombinator combinator5, Domain<T> predicate6, DomainCombinator combinator6, Domain<T> predicate7, DomainCombinator combinator7, Domain<T> predicate8, DomainCombinator combinator8, Domain<T> predicate9, DomainCombinator combinator9, Domain<T> predicate10) {
        domain = and(Domain.NewDomain(predicate1, combinator1, predicate2, combinator2, predicate3, combinator3, predicate4, combinator4, predicate5, combinator5, predicate6, combinator6, predicate7, combinator7, predicate8, combinator8, predicate9, combinator9, predicate10));
        return this;
    }

    private Domain<T> and(Domain<T> domain){
        return this.domain == null ? domain : Domain.NewDomain(this.domain, Domain.DomainCombinator.AND, domain);
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
    public SimpleQuery<T> sortAsc(ProjectionGetter<T> field1) {
        querySort.addAsc(field1);
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(ProjectionGetter<T> field1, ProjectionGetter<T> field2) {
        querySort.addAsc(field1);
        querySort.addAsc(field2);
        return this;
    }

    @Override
    public SimpleQuery<T> sortAsc(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3) {
        querySort.addAsc(field1);
        querySort.addAsc(field2);
        querySort.addAsc(field3);
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(ProjectionGetter<T> field1) {
        querySort.addDesc(field1);
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(ProjectionGetter<T> field1, ProjectionGetter<T> field2) {
        querySort.addDesc(field1);
        querySort.addDesc(field2);
        return this;
    }

    @Override
    public SimpleQuery<T> sortDesc(ProjectionGetter<T> field1, ProjectionGetter<T> field2, ProjectionGetter<T> field3) {
        querySort.addDesc(field1);
        querySort.addDesc(field2);
        querySort.addDesc(field3);
        return this;
    }
}
