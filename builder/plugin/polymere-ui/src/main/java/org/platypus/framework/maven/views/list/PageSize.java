package org.platypus.framework.maven.views.list;

import java.util.Objects;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public enum PageSize {
    _20("20"),
    _40("40"),
    _80("80"),
    ALL("ALL");

    private String value;

    PageSize(String value) {
        this.value = value;
    }

    public static PageSize fromValue(String value){
        if (Objects.equals(value, PageSize.ALL.value)){
            return PageSize.ALL;
        }
        return PageSize.valueOf("_"+value);
    }

    public String getValue() {
        return value;
    }
}
