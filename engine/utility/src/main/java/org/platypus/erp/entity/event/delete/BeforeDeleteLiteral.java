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
public class BeforeDeleteLiteral extends AnnotationLiteral<BeforeDelete> implements BeforeDelete {
    private final Class<?> clazz;

    public BeforeDeleteLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
