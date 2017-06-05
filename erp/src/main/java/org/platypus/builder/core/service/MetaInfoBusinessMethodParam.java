package org.platypus.builder.core.service;

import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class MetaInfoBusinessMethodParam {

    public final String pkg;
    public final List<String> type;
    public final String name;

    public MetaInfoBusinessMethodParam(String pkg, List<String> type, String name) {
        this.pkg = pkg;
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MetaInfoBusinessMethodParam{" +
                "pkg='" + pkg + '\'' +
                ", type='" + type + '\'' +
                ", methodName='" + name + '\'' +
                '}';
    }
}
