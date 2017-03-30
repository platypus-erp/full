package org.platypus.api;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface Pool {

    <R extends Record> R create(Class<R> tClass);
}
