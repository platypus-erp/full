package org.platypus.buildin;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public class Buildin {


    public static <T> T or(T value, T otherValue){
        return value != null ? value : otherValue;
    }

    public static <T,R> R ifThenApply(T value, Predicate<T> predicate, Function<T, R> function, R defaultValue){
        if (predicate.test(value)){
            return function.apply(value);
        }
        return defaultValue;
    }
}
