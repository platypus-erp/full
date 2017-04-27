package org.platypus.erp.entity.event.create;

import javax.enterprise.util.AnnotationLiteral;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class AfterCreateLiteral extends AnnotationLiteral<AfterCreate> implements AfterCreate {
    private final Class<?> clazz;

    public AfterCreateLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
