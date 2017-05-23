package org.platypus.erp.cdi.spi.erpmodule;

import javax.enterprise.util.AnnotationLiteral;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TotoModuleLiteral extends AnnotationLiteral<TotoModule> implements TotoModule {
    private final String name;

    public TotoModuleLiteral(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
