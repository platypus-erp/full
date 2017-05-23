package org.platypus.erp.cdi.exception;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TotoEntityBeanWithoutTable extends RuntimeException{
    public TotoEntityBeanWithoutTable(Class entity) {
        super(entity.getName() + " can't be used without @javax.persistence.Table");
    }
}
