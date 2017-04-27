package org.platypus.erp.manager;

import org.platypus.erp.entity.AbstractEntity;
import org.platypus.erp.entity.Identifiable;
import org.platypus.erp.rest.filter.Filter;
import org.platypus.erp.rest.filter.ListFilter;

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
public interface TotoRepository<E extends AbstractEntity> {
    void insert(@NotNull E e);

    void update(@NotNull E e);

    void delete(@NotNull E e);

    void delete(long id);

    void delete(@NotNull Identifiable identifiable);

    E getById(@NotNull Identifiable identifiable);

    E getById(long id);

    List<E> getList(ListFilter listFilter);

    int count(Filter filter);
}
