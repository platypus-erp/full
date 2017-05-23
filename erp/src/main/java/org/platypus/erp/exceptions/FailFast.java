package org.platypus.erp.exceptions;

import static java.util.Objects.isNull;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface FailFast {

    static void checkArgs(Object o) {
        if (isNull(o)) {
            throw new IllegalArgumentException("The argument can't be null");
        }
    }

    static void checkArgs(Object o, String msg) {
        if (o == null) {
            throw new IllegalArgumentException(msg);
        }
    }

    static void notYetImplemented() {
        throw new NotYetImplementedException("This method can't be called");
    }

    static void notYetImplemented(String methodeName) {
        throw new NotYetImplementedException("This method ["+methodeName+"] can't be called");
    }
}
