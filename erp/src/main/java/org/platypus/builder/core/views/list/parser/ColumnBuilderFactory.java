package org.platypus.builder.core.views.list.parser;


import org.platypus.builder.core.views.list.structure.column.ColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.ListViewColumn;
import org.platypus.builder.core.views.list.structure.column.boolcol.BooleanColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.currencycol.CurrencyColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.datecol.DateColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.datetimecol.DateTimeColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.floatcol.FloatColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.imgcol.ImgColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.integercol.IntegerColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.linkcol.LinkColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.relation.RelationColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.stringcol.StringColumnBuilder;
import org.platypus.builder.core.views.list.structure.column.timecol.TimeColumnBuilder;

import java.util.EnumMap;

import static java.util.Objects.requireNonNull;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ColumnBuilderFactory {

    private static EnumMap<ListViewColumn.ColumnType, ColumnBuilder> map = new EnumMap<>(ListViewColumn.ColumnType.class);
    static {
        registerBuilder(new StringColumnBuilder());
        registerBuilder(new BooleanColumnBuilder());
        registerBuilder(new CurrencyColumnBuilder());
        registerBuilder(new FloatColumnBuilder());
        registerBuilder(new IntegerColumnBuilder());
        registerBuilder(new ImgColumnBuilder());
        registerBuilder(new LinkColumnBuilder());
        registerBuilder(new DateColumnBuilder());
        registerBuilder(new DateTimeColumnBuilder());
        registerBuilder(new TimeColumnBuilder());
        registerBuilder(new RelationColumnBuilder());
    }

    static ColumnBuilder getBuilder(String nodeName){
        ListViewColumn.ColumnType col = ListViewColumn.ColumnType.fromXmlName(nodeName);
        System.out.println("request for node methodName : "+ nodeName+ "col find : "+ col);
        return map.get(col);
    }

    private static boolean registerBuilder(ColumnBuilder builder){
        requireNonNull(builder);
        return map.put(builder.validNodeName(), builder) == null;
    }
}
