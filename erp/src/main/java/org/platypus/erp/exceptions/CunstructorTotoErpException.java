package org.platypus.erp.exceptions;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class CunstructorTotoErpException extends RuntimeException {
    public CunstructorTotoErpException() {
        super("Please define an default constructor and call super(myEntity.class); Thanks");
    }
}
