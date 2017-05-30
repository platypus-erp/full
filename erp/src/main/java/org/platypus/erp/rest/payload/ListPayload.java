package org.platypus.erp.rest.payload;

import org.platypus.api.Record;

import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListPayload<E extends Record>{

    private final int count;
    private List<E> datas;

    public ListPayload(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public List<E> getDatas() {
        return datas;
    }

    public ListPayload setDatas(List<E> datas) {
        this.datas = datas;
        return this;
    }
}
