package org.platypus.api.query;

import org.platypus.api.Record;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 16/05/17.
 */
public interface SearchExecutor<T extends Record> {


    long count(SearchBuilder<T> searchBuilder);
    T getFirst(SearchBuilder<T> searchBuilder);
    List<T> get(SearchBuilder<T> searchBuilder);

}
