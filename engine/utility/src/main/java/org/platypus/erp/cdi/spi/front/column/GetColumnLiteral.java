package org.platypus.erp.cdi.spi.front.column;

import org.platypus.erp.entity.AbstractEntity;

import javax.enterprise.util.AnnotationLiteral;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class GetColumnLiteral extends AnnotationLiteral<GetColumn> implements GetColumn{
    private final Class<? extends AbstractEntity> clazz;

    public GetColumnLiteral(Class<? extends AbstractEntity> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<? extends AbstractEntity> value() {
        return clazz;
    }
}
