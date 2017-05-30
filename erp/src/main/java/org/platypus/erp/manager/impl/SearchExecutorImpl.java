package org.platypus.erp.manager.impl;

import org.platypus.api.Pool;
import org.platypus.api.Record;
import org.platypus.api.query.QueryExecutor;
import org.platypus.api.query.domain.visitor.JpaPredicateVisitorImpl;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.visitor.JpaProjectionInitializer;
import org.platypus.api.query.projection.visitor.JpaProjectionProjectionInitializer;
import org.platypus.api.query.projection.visitor.JpaProjectionResolverVisitorImpl;
import org.platypus.api.query.projection.visitor.JpaProjectionVisitorImpl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public class SearchExecutorImpl<T extends Record> implements QueryExecutor<T> {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Pool pool;

    private CriteriaBuilder cb;

    @Inject
    JpaProjectionVisitorImpl projectionVisitor;

    @Inject
    JpaPredicateVisitorImpl<T> jpaPredicateVisitor;

    @Inject
    JpaProjectionResolverVisitorImpl jpaProjectionResolverVisitor;

    private boolean distinct;
    private int page, limit, pageSize = 80;


    @PostConstruct
    public void postConstruct() {
        cb = entityManager.getCriteriaBuilder();
    }


    @Override
    public long count(SimpleQueryImpl<T> searchBuilder) {
        T instance = pool.get(searchBuilder.getTypeClass());
        Map<String, From<?, ?>> tableJoin = new HashMap<>();

        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<T> from = cq.from(searchBuilder.getTypeClass());
        tableJoin.put(instance.getName(), from);

        projectionVisitor.initWith(new JpaProjectionInitializer(tableJoin, from, cb));
        jpaPredicateVisitor.initWith(new JpaProjectionInitializer(tableJoin, from, cb));

        if (distinct){
            cq.select(cb.countDistinct(from.get("id")));
        } else {
            cq.select(cb.count(from.get("id")));
        }

        searchBuilder.getPredicate(instance).accept(jpaPredicateVisitor);

        cq.where(jpaPredicateVisitor.buildPredicate());

        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public Optional<T> getFirst(SimpleQueryImpl<T> searchBuilder) {
        List<T> res = get(searchBuilder);
        return res.isEmpty() ? Optional.empty() : Optional.of(res.get(0));
    }

    @Override
    public List<T> get(SimpleQueryImpl<T> searchBuilder) {
        return searchBuilder.getAllField() ? getAllField(searchBuilder) : getListTuple(searchBuilder);
    }

    public List<T> getAllField(SimpleQueryImpl<T> searchBuilder) {
        T instance = pool.get(searchBuilder.getTypeClass());
        Map<String, From<?, ?>> tableJoin = new HashMap<>();

        CriteriaQuery<T> cq = cb.createQuery(searchBuilder.getTypeClass());
        Root<T> from = cq.from(searchBuilder.getTypeClass());

        tableJoin.put(instance.getName(), from);

        jpaPredicateVisitor.initWith(new JpaProjectionInitializer(tableJoin, from, cb));

        searchBuilder.getPredicate(instance).accept(jpaPredicateVisitor);

        cq.where(jpaPredicateVisitor.buildPredicate());
        cq.distinct(distinct);
        List<T> res = entityManager.createQuery(cq)
                .setFirstResult(page * pageSize)
                .setMaxResults(limit)
                .getResultList();
        return res;
    }

    private List<T> getListTuple(SimpleQueryImpl<T> searchBuilder) {
        T instance = pool.get(searchBuilder.getTypeClass());
        Map<String, From<?, ?>> tableJoin = new HashMap<>();

        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<T> from = cq.from(searchBuilder.getTypeClass());
        tableJoin.put(instance.getName(), from);

        projectionVisitor.initWith(new JpaProjectionInitializer(tableJoin, from, cb));
        jpaPredicateVisitor.initWith(new JpaProjectionInitializer(tableJoin, from, cb));

        searchBuilder.getProjection(instance)
                .forEach(p -> p.accept(projectionVisitor));

        cq.multiselect(projectionVisitor.getSelect());

        searchBuilder.getPredicate(instance).accept(jpaPredicateVisitor);

        cq.where(jpaPredicateVisitor.buildPredicate());
        cq.distinct(distinct);
        List<Tuple> res = entityManager.createQuery(cq)
                .setFirstResult(page * pageSize)
                .setMaxResults(limit)
                .getResultList();

        List<T> result = new ArrayList<>(res.size());
        for(Tuple tuple: res){
            T newInstance = pool.get(searchBuilder.getTypeClass());
            jpaProjectionResolverVisitor.initWith(new JpaProjectionProjectionInitializer(tuple));
            searchBuilder.getProjection(newInstance)
                    .forEach(p -> p.accept(jpaProjectionResolverVisitor));
            result.add(newInstance);
        }
        return result;
    }

    public QueryExecutor<T> distinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    public QueryExecutor<T> limit(int limit) {
        this.limit = limit;
        return null;
    }

    public QueryExecutor<T> page(int page) {
        this.page = page;
        return null;
    }

    public QueryExecutor<T> page(int pageNumber, int pageSize) {
        this.page = pageNumber;
        this.pageSize = pageSize;
        return null;
    }
}