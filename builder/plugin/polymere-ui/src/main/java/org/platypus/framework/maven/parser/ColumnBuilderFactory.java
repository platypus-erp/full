package org.platypus.framework.maven.parser;


import org.platypus.framework.maven.views.list.column.ColumnBuilder;
import org.platypus.framework.maven.views.list.column.ListViewColumn;
import org.platypus.framework.maven.views.list.column.boolcol.BooleanColumnBuilder;
import org.platypus.framework.maven.views.list.column.currencycol.CurrencyColumnBuilder;
import org.platypus.framework.maven.views.list.column.datecol.DateColumnBuilder;
import org.platypus.framework.maven.views.list.column.datetimecol.DateTimeColumnBuilder;
import org.platypus.framework.maven.views.list.column.floatcol.FloatColumnBuilder;
import org.platypus.framework.maven.views.list.column.imgcol.ImgColumnBuilder;
import org.platypus.framework.maven.views.list.column.integercol.IntegerColumnBuilder;
import org.platypus.framework.maven.views.list.column.linkcol.LinkColumnBuilder;
import org.platypus.framework.maven.views.list.column.stringcol.StringColumnBuilder;
import org.platypus.framework.maven.views.list.column.timecol.TimeColumnBuilder;
import org.platypus.framework.maven.views.list.column.relation.RelationColumnBuilder;

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
        System.out.println("request for node name : "+ nodeName+ "col find : "+ col);
        return map.get(col);
    }

    private static boolean registerBuilder(ColumnBuilder builder){
        requireNonNull(builder);
        return map.put(builder.validNodeName(), builder) == null;
    }
}
