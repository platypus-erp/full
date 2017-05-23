package org.platypus.erp.service;

import org.platypus.erp.entity.AbstractEntity;
import org.platypus.erp.entity.Identifiable;
import org.platypus.erp.entity.event.create.AfterCreateLiteral;
import org.platypus.erp.entity.event.create.BeforeCreateLiteral;
import org.platypus.erp.entity.event.delete.AfterDeleteLiteral;
import org.platypus.erp.entity.event.delete.BeforeDeleteLiteral;
import org.platypus.erp.entity.event.select.id.AfterSelectByIdLiteral;
import org.platypus.erp.entity.event.select.id.BeforeSelectByIdLiteral;
import org.platypus.erp.entity.event.update.AfterUpdateLiteral;
import org.platypus.erp.entity.event.update.BeforeUpdateLiteral;
import org.platypus.erp.exceptions.CunstructorTotoErpException;
import org.platypus.erp.manager.TotoRepository;
import org.platypus.erp.rest.filter.Filter;
import org.platypus.erp.rest.filter.ListFilter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractRestEventService<M extends TotoRepository<E>, E extends AbstractEntity> implements TotoRepository<E> {

    final Class<E> clazz;
    @Inject
    Event<E> event;
    @Inject
    Event<Long> eventId;
    @Inject
    private M manager;

    /**
     * This constructor can't be called
     *
     * @throws CunstructorTotoErpException
     */
    protected AbstractRestEventService() {
        throw new CunstructorTotoErpException();
    }

    public AbstractRestEventService(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(@NotNull E e) {
        event.select(new BeforeCreateLiteral(clazz)).fire(e);
        manager.insert(e);
        event.select(new AfterCreateLiteral(clazz)).fire(e);
    }

    @Override
    public void update(@NotNull E e) {
        event.select(new BeforeUpdateLiteral()).fire(e);
        manager.update(e);
        event.select(new AfterUpdateLiteral()).fire(e);
    }

    @Override
    public void delete(@NotNull E e) {
        event.select(new BeforeDeleteLiteral(clazz)).fire(e);
        manager.delete(e);
        event.select(new AfterDeleteLiteral(clazz)).fire(e);
    }

    @Override
    public void delete(long id) {
        eventId.select(new BeforeDeleteLiteral(clazz)).fire(id);
        manager.delete(id);
        eventId.select(new AfterDeleteLiteral(clazz)).fire(id);
    }

    @Override
    public void delete(@NotNull Identifiable id) {
        eventId.select(new BeforeDeleteLiteral(clazz)).fire(id.getId());
        manager.delete(id);
        eventId.select(new AfterDeleteLiteral(clazz)).fire(id.getId());
    }

    @Override
    public E getById(@NotNull Identifiable id) {
        eventId.select(new BeforeSelectByIdLiteral(clazz)).fire(id.getId());
        E e = manager.getById(id);
        event.select(new AfterSelectByIdLiteral(clazz)).fire(e);
        return e;
    }

    @Override
    public E getById(long id) {
        eventId.select(new BeforeSelectByIdLiteral(clazz)).fire(id);
        E e = manager.getById(id);
        if (e != null) {
            event.select(new AfterSelectByIdLiteral(clazz)).fire(e);
        }
        return e;
    }

    @Override
    public List<E> getList(ListFilter listFilter) {
        return manager.getList(listFilter);
    }

    public int count(Filter filter){
        return manager.count(filter);
    }
}
