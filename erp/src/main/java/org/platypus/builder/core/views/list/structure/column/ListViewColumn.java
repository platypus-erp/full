package org.platypus.builder.core.views.list.structure.column;

import j2html.tags.ContainerTag;
import org.platypus.builder.core.views.list.structure.SortableTag;

import java.util.Arrays;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ListViewColumn {

    enum ColumnType{
        STRING("string-column"),
        DATE("date-column"),
        DATE_TIME("date-time-column"),
        TIME("time-column"),
        IMG("img-column"),
        BOOLEAN("boolean-column"),
        INTEGER("integer-column"),
        FLOAT("float-column"),
        CURRENCY("currency-column"),
        RELATION("relation-column"),
        LINK("link-column");

        private String xmlName;

        public String getXmlName() {
            return xmlName;
        }

        ColumnType(String xmlName) {
            this.xmlName = xmlName;
        }

        public static ColumnType fromXmlName(final String xmlName){
            return Arrays.stream(ColumnType.values())
                    .filter(c -> c.xmlName.equals(xmlName))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException(xmlName));
        }
    }
    String getId();
    ColumnType getColumnType();
    String getPropertyName();
    boolean isFilterable();
    SortableTag getSortableTag();
    String getHeaderLabelKey();
    int getOrder();
    void setOrder(int order);
    boolean isActif();

    ContainerTag toContainerTag();


}
