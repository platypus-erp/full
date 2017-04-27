package org.platypus.erp.rest.filter;

import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.function.BiConsumer;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface Filter<E extends AbstractEntity> extends BiConsumer<CriteriaQuery<Tuple>, CriteriaBuilder> {

    int getPage();

    int getPageSize();
}
