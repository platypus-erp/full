package org.platypus.api.service;

import org.platypus.api.Record;
import org.platypus.api.query.Domain;
import org.platypus.api.query.SimpleQuery;
import org.platypus.api.query.SimpleQueryFactory;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.erp.entity.Identifiable;
import org.platypus.erp.entity.event.create.AfterCreateLiteral;
import org.platypus.erp.entity.event.create.BeforeCreateLiteral;
import org.platypus.erp.entity.event.delete.AfterDeleteLiteral;
import org.platypus.erp.entity.event.delete.BeforeDeleteLiteral;
import org.platypus.erp.entity.event.select.id.AfterSelectByIdLiteral;
import org.platypus.erp.entity.event.select.id.BeforeSelectByIdLiteral;
import org.platypus.erp.entity.event.update.AfterUpdateLiteral;
import org.platypus.erp.entity.event.update.BeforeUpdateLiteral;
import org.platypus.erp.exceptions.CunstructorPlatypuErpException;
import org.platypus.erp.manager.PlatypusRepository;
import org.platypus.erp.rest.filter.Filter;
import org.platypus.erp.rest.filter.ListFilter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.function.Function;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public abstract class PlatypusService<E extends Record> {

    protected final Class<E> clazz;
    @Inject
    Event<E> event;
    @Inject
    Event<Long> eventId;
    @Inject
    private PlatypusRepository<E> manager;

    @Inject
    SimpleQueryFactory<E> queryFactory;

    /**
     * This constructor can't be called
     *
     * @throws CunstructorPlatypuErpException
     */
    protected PlatypusService() {
        throw new CunstructorPlatypuErpException();
    }

    public PlatypusService(Class<E> clazz) {
        this.clazz = clazz;
    }

    public void insert(@NotNull E e) {
        event.select(new BeforeCreateLiteral(clazz)).fire(e);
        manager.insert(e);
        event.select(new AfterCreateLiteral(clazz)).fire(e);
    }

    public void update(@NotNull E e) {
        event.select(new BeforeUpdateLiteral()).fire(e);
        manager.update(e);
        event.select(new AfterUpdateLiteral()).fire(e);
    }

    public void delete(@NotNull E e) {
        event.select(new BeforeDeleteLiteral(clazz)).fire(e);
        manager.delete(e);
        event.select(new AfterDeleteLiteral(clazz)).fire(e);
    }

    public void delete(long id) {
        eventId.select(new BeforeDeleteLiteral(clazz)).fire(id);
        manager.delete(id);
        eventId.select(new AfterDeleteLiteral(clazz)).fire(id);
    }

    public void delete(@NotNull Identifiable id) {
        eventId.select(new BeforeDeleteLiteral(clazz)).fire(id.getId());
        manager.delete(id);
        eventId.select(new AfterDeleteLiteral(clazz)).fire(id.getId());
    }

    public E getById(@NotNull Identifiable id) {
        eventId.select(new BeforeSelectByIdLiteral(clazz)).fire(id.getId());
        E e = manager.getById(id);
        event.select(new AfterSelectByIdLiteral(clazz)).fire(e);
        return e;
    }

    public E getById(long id) {
        eventId.select(new BeforeSelectByIdLiteral(clazz)).fire(id);
        E e = manager.getById(id);
        if (e != null) {
            event.select(new AfterSelectByIdLiteral(clazz)).fire(e);
        }
        return e;
    }


    public List<E> getList(ListFilter listFilter) {
        return manager.getList(listFilter);
    }

    public List<E> getList(Domain<E> domain) {
        return manager.executeAsList(queryFactory.of(clazz).filter(domain));
    }

    public List<E> execute(SimpleQuery<E> query) {
        return manager.executeAsList(query);
    }

    public List<E> search(Function<SimpleQuery<E>, SimpleQuery<E>> query) {
        return execute(query.apply(queryFactory.of(clazz)));
    }

    public int count(String filterId) {
        return 0;
    }

    public int count(Filter<E> filter) {
        return manager.count(filter);
    }

    public int count(SimpleQuery<E> query) {
        return manager.count(query);
    }

    public int count(Function<E, PPredicate<?>> domain) {
        return manager.count(domain);
    }
}
