package org.platypus.builder.core.views.list.structure.column.datecol;

import org.platypus.builder.core.views.list.structure.column.ListViewColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ListViewDateColumn extends ListViewColumn {

    enum DisplayType{
        NORMAL("normal"),
        SHORT("short"),
        LONG("long");

        private String value;

        public String getValue() {
            return value;
        }

        DisplayType(String value) {
            this.value = value;
        }

        public static DisplayType fromValue(String value){
            return DisplayType.valueOf(value.toUpperCase());
        }
    }

    DisplayType getDisplayType();
}
