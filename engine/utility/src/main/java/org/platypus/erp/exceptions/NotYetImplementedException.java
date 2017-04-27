package org.platypus.erp.exceptions;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class NotYetImplementedException extends UnsupportedOperationException{

    public NotYetImplementedException() {

    }

    public NotYetImplementedException(String message) {
        super(message);
    }
}
