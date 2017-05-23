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
public class AfterSelectListLiteral extends AnnotationLiteral<AfterSelectList> implements AfterSelectList {

    private final Class<?> clazz;

    public AfterSelectListLiteral(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<?> value() {
        return clazz;
    }
}
