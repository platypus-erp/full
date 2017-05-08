package org.platypus.buildin;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public interface Buildin {

    static <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate, Supplier<Collection<T>> collectionFactory) {
        return collection.stream().filter(predicate).collect(Collectors.toCollection(collectionFactory));
    }

    static <T, C extends Collection<T>> Collection<T> filter(Collection<T> collection, Predicate<T> predicate, Collector<T, ?, C> collector){
        return collection.stream().filter(predicate).collect(collector);
    }

    static <T> List<T> filter(List<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }

    static <T> Set<T> filter(Set<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toSet());
    }
}
