package org.platypus.erp.cdi.spi;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class SimpleEntityRegistry {

    private String targetTable;
    private String annotatedWith;
    private boolean optional;

    public SimpleEntityRegistry(String targetTable,boolean optional, String annotatedWith) {
        this.targetTable = targetTable;
        this.annotatedWith = annotatedWith;
        this.optional = optional;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public String getAnnotatedWith() {
        return annotatedWith;
    }
}
