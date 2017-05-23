package org.platypus.erp.entity.event.select.list;

import javax.enterprise.util.AnnotationLiteral;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class BeforeSelectListLiteral extends AnnotationLiteral<BeforeSelectList> implements BeforeSelectList {

    private final Class<?> clazz;

    public BeforeSelectListLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
