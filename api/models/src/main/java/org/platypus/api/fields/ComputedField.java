package org.platypus.api.fields;

import org.platypus.api.Record;

import java.util.function.Consumer;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
@FunctionalInterface
public interface ComputedField<R extends Record> extends Consumer<R> {

    default void inverse(Consumer<R> inversFunction){

    }
}
