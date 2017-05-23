package org.platypus.erp.manager;

import org.platypus.erp.entity.AbstractEntity;
import org.platypus.erp.entity.Identifiable;
import org.platypus.erp.rest.filter.Filter;
import org.platypus.erp.rest.filter.ListFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractRepository<E extends AbstractEntity> implements TotoRepository<E> {

    private final Class<E> clazz;
    private final Logger LOG = LoggerFactory.getLogger(AbstractRepository.class);

    @PersistenceContext
    protected EntityManager em;

    public AbstractRepository(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(@NotNull E e) {
        em.persist(e);
    }

    @Override
    public void update(@NotNull E e) {
        em.merge(e);
    }

    @Override
    public void delete(@NotNull E e) {
        em.remove(e);
    }

    @Override
    public void delete(long id) {
        em.remove(getById(id));
    }

    @Override
    public void delete(@NotNull Identifiable identifiable) {
        em.remove(getById(identifiable.getId()));
    }

    @Override
    public E getById(@NotNull Identifiable identifiable) {
        return getById(identifiable.getId());
    }

    @Override
    public E getById(long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<E> getList(ListFilter listFilter) {
//        Optional<String> name = EntityRegistry.INSTANCE.getName(clazz);
//        if (name.isPresent()) {
//            String target = name.get();
//            ListConf conf = columnsCache.getColumns(target);
//            try (org.jooq.Query step = createQuery(conf, listFilter, target)) {
//                javax.persistence.Query result = em.createNativeQuery(step.getSQL(), clazz);
//                // Extract the bind values from the jOOQ query:
//                List<Object> values = step.getBindValues();
//                for (int i = 0; i < values.size(); i++) {
//                    result.setParameter(i + 1, values.get(i));
//                }
//                return result.getResultList();
//            }
//        } else {
//            return new ArrayList<>();
//        }
        return null;
    }

//    private org.jooq.Query createQuery(ListConf conf, ListFilter listFilter, String target) {
//        List<Col> columns = conf.getColumns();
//        // TODO convert to custom container et fire event
//        Collection<SelectField> cols = new ArrayList<>(columns.size());
//        for (Col col : columns) {
//            cols.add(col.toJooqField());
//        }
//
//
//
//
//
//
//        DSL.select(cols.toArray(new SelectField[cols.size()]))
//        .from(target)
//        .innerJoin(table(target).join(table(target)).on(field(target).eq(field(target))));
//        return selectFrom(table(target))
//                .orderBy(field("id"))
//                .limit(listFilter.getPageSize())
//                .offset(listFilter.getPage() * listFilter.getPageSize());
//    }

    @Override
    public int count(Filter filter) {
//        Optional<String> name = EntityRegistry.INSTANCE.getName(clazz);
//        if (name.isPresent()) {
//            try (org.jooq.Query step = selectCount().from(table(name.get()))) {
//                javax.persistence.Query query = em.createNativeQuery(step.getSQL());
//                return Number.class.cast(query.getSingleResult()).intValue();
//            }
//        } else {
        return 0;
//        }
    }
}