package org.platypus.erp.entity;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public interface Identifiable {

    /**
     * Return de value of the primary key of the table
     * @return 0 if the entity Bean is not persited or the value
     */
    long getId();
}
