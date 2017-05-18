package org.platypus.api.query;

import org.platypus.api.Pool;
import org.platypus.api.Record;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
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
public class SearchExecutorImpl<T extends Record> implements SearchExecutor<T> {

    EntityManager entityManager;
    Pool pool;


    @Override
    public long count(SearchBuilder<T> searchBuilder) {
        T instance = pool.get(searchBuilder.getClassResult());
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(searchBuilder.getClassResult());
        Root<T> from = cq.from(searchBuilder.getClassResult());

        List<ProjectionField<T>> projection = searchBuilder.getProjection();
        String mainTableName = instance.getName();

        Map<String, Join<?, ?>> tableJoin = new HashMap<>();

        List<Selection<?>> select = new ArrayList<>();
        for (ProjectionField<T> pro : projection) {
            QueryPath path = pro.getField().apply(instance).getPath();
            QueryPath pathreverse = path.reverse();
            cq.multiselect(select);


            System.out.println(path);
            From<?, ?> join = getJoin(path, tableJoin, from);
            if (path.isRelation) {
                //Appended only when the field needed is en relation and we want only the name field + the id
//                automaticaly add the field name
                if (path.next == null) {
                    //TODO get all field needed for display name
                    select.add(join.get("name"));
                    select.add(join.get("id"));
                }
            } else {
                if (pro.aggregator == null) {
                    select.add(from.get(path.columnName));
                } else {
                    switch (pro.aggregator) {
                        case AVG:
                            select.add(cb.avg(from.get(path.columnName)));
                        case MAX:
                            select.add(cb.max(from.get(path.columnName)));
                        case MIN:
                            select.add(cb.min(from.get(path.columnName)));
                        case SUM:
                            select.add(cb.sum(from.get(path.columnName)));
                        case COUNT:
                            select.add(cb.count(from.get(path.columnName)));
                        case CONCAT:
                            select.add(cb.concat(from.get(path.columnName), pro.getSupValue().toString()));

                    }
                }
            }


            System.out.println(path.tableName);
            System.out.println(path.columnName);
            System.out.println(path.isRelation);
        }


        return 0;
    }

    private From<?, ?> getJoin(QueryPath path, Map<String, Join<?, ?>> tableJoin, From<?, ?> from) {
        From<?, ?> j = tableJoin.getOrDefault(path.tableName, from.join(path.columnName));
        if (path.isRelation) {
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
