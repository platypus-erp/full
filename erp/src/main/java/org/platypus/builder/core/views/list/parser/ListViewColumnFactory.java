package org.platypus.builder.core.views.list.parser;

import org.platypus.builder.core.views.list.structure.column.ListViewColumn;

import java.util.EnumMap;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ListViewColumnFactory {

    private static EnumMap<ListViewColumn.ColumnType, ListViewColumn> map = new EnumMap<>(ListViewColumn.ColumnType.class);

    static <T> T getImpl(ListViewColumn.ColumnType columnType){
        return (T) map.get(columnType);
    }

    public static <T extends ListViewColumn> boolean registerImpl(ListViewColumn.ColumnType type, T listViewColumn){
        return map.put(type, listViewColumn) == null;
    }
}
