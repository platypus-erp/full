package org.platypus.erp.cdi.spi.front.column;

import org.platypus.api.Record;

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
    private final Class<? extends Record> clazz;

    public GetColumnLiteral(Class<? extends Record> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<? extends Record> value() {
        return clazz;
    }
}
