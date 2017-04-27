package org.platypus.framework.maven.views.list.column.imgcol;

import org.platypus.framework.maven.views.list.column.ListViewColumn;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ListViewImgColumn extends ListViewColumn {

    enum Mask {
        SQUARE("square"),
        CIRCLE("circle"),
        STAR("star");

        private String value;

        Mask(String value) {
            this.value = value;
        }

        public static Mask fromValue(String mask) {
            return Mask.valueOf(mask.toUpperCase());
        }
    }

    enum Type {
        BASE_64("base_64"),
        ICON("icon"),
        LINK("link");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public static Type fromValue(String type) {
            return Type.valueOf(type.toUpperCase());
        }
    }

    Type getType();

    Mask getMask();
}
