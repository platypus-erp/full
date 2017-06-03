package org.platypus.builder.core.service;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class MetaInfoBusinessMethodParam {

    public final String pkgName;
    public final String name;
    public final boolean nullable;

    public MetaInfoBusinessMethodParam(String pkgName, String name, boolean nullable) {
        this.pkgName = pkgName;
        this.name = name;
        this.nullable = nullable;
    }
}
