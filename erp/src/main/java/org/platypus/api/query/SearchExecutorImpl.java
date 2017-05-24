package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.Pool;
import org.platypus.api.Record;
import org.platypus.api.query.predicate.QueryPredicate;
import org.platypus.api.query.predicate.impl.PredicateNode;
import org.platypus.api.query.predicate.impl.PredicateTree;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public class SearchExecutorImpl<T extends Record> implements SearchExecutor<T> {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Pool pool;


    @Override
    public long count(SearchBuilder<T> searchBuilder) {
        T instance = pool.get(searchBuilder.getClassResult());
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
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
            QueryPath path = pro.getField().apply(instance).getPath();
            QueryPath pathreverse = path.reverse();

            System.out.println(pathreverse.getTablePath());
            System.out.println(pathreverse.columnName);
            System.out.println(pathreverse.isRelation);

            System.out.println(path);
            From<?, ?> join = getJoin(path, tableJoin, from);
            if (path.isRelation) {
                //Appended only when the field needed is en relation and we want only the name field + the id
//                automaticaly add the field name
                if (path.next == null) {
                    //TODO get all field needed for display name
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
        PredicateTree<T> tree = searchBuilder.getPredicateTree();
        PredicateTree<T> left = tree.getLeft();
        PredicateNode<T> right = tree.getRight();
        PredicateCombinator combinator = tree.getCondition();


        List<Tuple> tuples = entityManager.createQuery(cq).getResultList();

        return 0;
    }


    private Predicate nodeToPredicate(CriteriaBuilder cb, PredicateNode<T> node, T instance, Map<String, From<?, ?>> tableJoin, From<?, ?> from) {
        if (node == null) {
            return null;
        }
        QueryPredicate<? extends PlatypusField<?>> predicateLeft = node.getLeft().apply(instance);
        PlatypusField<?> field = predicateLeft.getRight();


        Path<?> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        PlatypusField<?> value = predicateLeft.getLeft();
        Path<?> path2 = null;
        if (value.isEmpty()) {
            path2 = getJoin(value.getPath().reverse(), tableJoin, from).get(value.getPath().columnName);
        }

        switch (predicateLeft.getCondition()) {
            case EQ:
                return value.isEmpty() ? cb.equal(path1, path2) : cb.equal(path1, value.get());
        }
        return null;
    }

    private From<?, ?> getJoin(QueryPath path, Map<String, From<?, ?>> tableJoin, From<?, ?> from) {
        From<?, ?> j = tableJoin.get(path.getTablePath());
        if (j == null) {
            j = from.join(path.columnName);
            tableJoin.putIfAbsent(path.getTablePath(), j);
        }
        if (path.isRelation && path.next != null) {
            j = getJoin(path.next, tableJoin, j);
        }
        return j;
    }

    @Override
    public T getFirst(SearchBuilder<T> searchBuilder) {
        return null;
    }

    @Override
    public List<T> get(SearchBuilder<T> searchBuilder) {
        return null;
    }
}
