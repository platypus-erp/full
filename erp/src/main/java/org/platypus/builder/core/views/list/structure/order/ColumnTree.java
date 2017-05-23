package org.platypus.builder.core.views.list.structure.order;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ColumnTree {

    private List<ColumnTree> columnBefore;
    private List<ColumnTree> columnAfter;
    private int maxAfter;
    private int minBefore;
    private String id;
    private int order;

    public ColumnTree(String id, int order) {
        this.id = id;
        this.order = order;
        this.maxAfter = order + 50;
        this.minBefore = order - 50;
        columnBefore = new ArrayList<>();
        columnAfter = new ArrayList<>();
    }

    public int getOrder() {
        return order;
    }

    public ColumnTree addBefore(String colId) {
        this.minBefore--;
        ColumnTree before = new ColumnTree(colId, this.minBefore);
        columnBefore.add(before);
        return before;
    }

    public ColumnTree addAfter(String colId) {
        this.maxAfter++;
        ColumnTree after = new ColumnTree(colId, this.maxAfter);
        columnAfter.add(after);
        return after;
    }
}
