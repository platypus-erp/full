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
public class BeforeCreateLiteral extends AnnotationLiteral<BeforeCreate> implements BeforeCreate {
    private final Class<?> clazz;

    public BeforeCreateLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
