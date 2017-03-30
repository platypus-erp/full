package org.platypus.api;


import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface Repository<R extends Record> {

    R create();

    void insert(R e);

    void update(R e);

    void delete(R e);

    void delete(long id);

    R getById(long id);

    List<R> getList();

    int count();
}
