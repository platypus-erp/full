package org.platypus.api;


import java.util.List;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface RecordCollection<T extends Record> {

    <R extends T> Set<R> asSet(Class<R> record);
    <R extends T> List<R> asList(Class<R> record);

    <R extends T> R first();
    <R extends T> R first(Class<R> rClass);

    <R extends T> R last();
    <R extends T> R last(Class<R> rClass);

    <R extends T> R requiredOne();
    <R extends T> R requiredOne(Class<R> rClass);
    boolean isSingleValue();
}
