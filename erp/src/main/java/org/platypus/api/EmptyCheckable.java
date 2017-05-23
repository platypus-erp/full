package org.platypus.api;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface EmptyCheckable {

    boolean isEmpty();
    default boolean isNotEmpty(){
        return !isEmpty();
    }

}
