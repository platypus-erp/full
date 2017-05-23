package org.platypus.erp.exceptions;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TotoJsonMappingException extends RuntimeException{
    public TotoJsonMappingException() {
        super();
    }

    public TotoJsonMappingException(String message) {
        super(message);
    }

    public TotoJsonMappingException(Throwable cause) {
        super(cause);
    }
}
