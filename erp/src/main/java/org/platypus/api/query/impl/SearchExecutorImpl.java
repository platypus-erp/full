package org.platypus.api.query.impl;

import org.platypus.api.Pool;
import org.platypus.api.Record;
import org.platypus.api.query.QueryExecutor;
import org.platypus.api.query.projection.ProjectionField;
import org.platypus.api.query.QueryBuilder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    CriteriaBuilder cb;
    
    @PostConstruct
    public void postConstruct(){
        cb = entityManager.getCriteriaBuilder();
    }


    @Override
    @SuppressWarnings("unchecked")
    public long count(QueryBuilder<T> searchBuilder) {
        PlatypusToJpa p2j = new PlatypusToJpa(cb);
        T instance = pool.get(searchBuilder.getClassResult());
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<T> from = cq.from((Class<T>) instance.getClass());

        List<ProjectionField<T>> projection = searchBuilder.getProjection();
        String mainTableName = instance.getName();

        Map<String, From<?, ?>> tableJoin = new HashMap<>();
        tableJoin.put(mainTableName, from);

        List<Selection<?>> select = new ArrayList<>();
        List<Expression<?>> selectNonAgregator = new ArrayList<>();
        List<Selection<?>> selectAggregator = new ArrayList<>();
        for (ProjectionField<T> pro : projection) {
            QueryPathImpl path = pro.getField().apply(instance).getPath();
            QueryPathImpl pathreverse = path.reverse();

            System.out.println(pathreverse.getTablePath());
            System.out.println(pathreverse.columnName);
            System.out.println(pathreverse.isRelation);

            System.out.println(path);
            From<?, ?> join = p2j.getJoin(path, tableJoin, from);
            if (path.isRelation) {
                //Appended only when the aggregate needed is en relation and we want only the name aggregate + the id
//                automaticaly add the aggregate name
                if (path.next == null) {
                    //TODO get all aggregate needed for display name
//                    select.add(join.get("name"));
                    select.add(join.get("id"));
                    selectNonAgregator.add(join.get("id"));
                }
            } else {
                if (pro.aggregator == null) {
                    select.add(from.get(path.columnName));
                    selectNonAgregator.add(from.get(path.columnName));
                } else {
                    switch (pro.aggregator) {
                        case AVG:
                            selectAggregator.add(cb.avg(from.get(path.columnName)));
                            break;
                        case MAX:
                            selectAggregator.add(cb.max(from.get(path.columnName)));
                            break;
                        case MIN:
                            selectAggregator.add(cb.min(from.get(path.columnName)));
                            break;
                        case SUM:
                            selectAggregator.add(cb.sum(from.get(path.columnName)));
                            break;
                        case COUNT:
                            selectAggregator.add(cb.count(from.get(path.columnName)));
                            break;
                        case CONCAT:
                            selectAggregator.add(cb.concat(from.get(path.columnName), pro.getSupValue().toString()));
                            break;

                    }
                }
            }
        }
        cq.multiselect(select);
        cq.multiselect(selectAggregator);
        if (!selectAggregator.isEmpty()) {
            cq.groupBy(selectNonAgregator);
        }
        //TODO make recusive
        PredicateTree<T> tree = searchBuilder.getPredicateTree();

        FilterContainer<T> filter = tree.getFilter();
        FilterResolver<T> resolver = new FilterResolver<>(instance, filter);
        Predicate predicate = resolveJpaPredicate(p2j, from, tableJoin, resolver);


        cq.where(predicate);


        List<Tuple> lines = entityManager.createQuery(cq).getResultList();
        instance.

        return 0;
    }

    private Predicate resolveJpaPredicate(PlatypusToJpa p2j,
                                     Root<T> from,
                                     Map<String, From<?, ?>> tableJoin,
                                     FilterResolver<T> resolver) {
        Predicate res = null;
        for (String order : resolver.getOrder()) {
            switch (resolver.getType(order)) {
                case BIG_STRING:
                    res = and(res, p2j.bigStringToPredicate(resolver.getBigString(order), tableJoin, from));
                    break;
                case BINARY:
                    res = and(res, p2j.binaryToPredicate(resolver.getBinary(order), tableJoin, from));
                    break;
                case BOOLEAN:
                    res = and(res, p2j.booleanToPredicate(resolver.getBoolean(order), tableJoin, from));
                    break;
                case DATE:
                    res = and(res, p2j.dateToPredicate(resolver.getDate(order), tableJoin, from));
                    break;
                case DATE_TIME:
                    res = and(res, p2j.dateTimeToPredicate(resolver.getDateTime(order), tableJoin, from));
                    break;
                case DECIMAL:
                    res = and(res, p2j.decimalToPredicate(resolver.getDecimal(order), tableJoin, from));
                    break;
                case FLOAT:
                    res = and(res, p2j.floatToPredicate(resolver.getFloat(order), tableJoin, from));
                    break;
                case INT:
                    res = and(res, p2j.intToPredicate(resolver.getInt(order), tableJoin, from));
                    break;
                case LONG:
                    res = and(res, p2j.longToPredicate(resolver.getLong(order), tableJoin, from));
                    break;
                case STRING:
                    res = and(res, p2j.stringToPredicate(resolver.getString(order), tableJoin, from));
                    break;
                case TIME:
                    res = and(res, p2j.timeToPredicate(resolver.getTime(order), tableJoin, from));
                    break;
                default:
                    throw new UnsupportedOperationException(
                            "The aggregate" + order + " of type" + resolver.getType(order) + " is not supported"
                    );
            }
        }
        
        return res;
    }
    
    private Predicate and(Predicate p1, Predicate p2){
        if (p1 == null){
            return p2;
        } else {
            return cb.and(p1, p2);
        }
    }

    @Override
    public T getFirst(QueryBuilder<T> searchBuilder) {
        return null;
    }

    @Override
    public List<T> get(QueryBuilder<T> searchBuilder) {
        return null;
    }
}
