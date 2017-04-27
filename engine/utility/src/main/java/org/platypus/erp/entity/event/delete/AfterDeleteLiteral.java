package org.platypus.erp.entity.event.delete;

import javax.enterprise.util.AnnotationLiteral;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class AfterDeleteLiteral extends AnnotationLiteral<AfterDelete> implements AfterDelete {

    private final Class<?> clazz;

    public AfterDeleteLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
