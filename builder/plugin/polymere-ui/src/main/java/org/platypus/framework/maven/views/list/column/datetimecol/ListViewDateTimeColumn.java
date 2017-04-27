package org.platypus.framework.maven.views.list.column.datetimecol;

import org.platypus.framework.maven.views.list.column.ListViewColumn;

import java.util.Arrays;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ListViewDateTimeColumn extends ListViewColumn {
    enum DisplayType{
        SHORT("short"),
        MONTH_SHORT("month-short"),
        MONTH_LONG("month-long"),
        MONTH_DAY_SHORT("month-day-short"),
        MONTH_DAY_LONG("month-day-long");

        private String value;

        public String getValue() {
            return value;
        }

        DisplayType(String value) {
            this.value = value;
        }

        public static DisplayType fromValue(String displayAttribute) {
            return Arrays.stream(DisplayType.values())
                    .filter(d -> d.value.equals(displayAttribute))
                    .findAny()
                    .orElseThrow(RuntimeException::new);
        }
    }

    DisplayType getDisplayType();
}
