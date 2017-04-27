package org.platypus.erp.entity.event.select.id;

import javax.enterprise.util.AnnotationLiteral;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class AfterSelectByIdLiteral extends AnnotationLiteral<AfterSelectById> implements AfterSelectById {

    private final Class<?> clazz;

    public AfterSelectByIdLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
