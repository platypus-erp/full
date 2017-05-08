package org.platypus.api;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public interface QueryPath {

    String getPath();

    default String[] getPathSplited(){
        return getPath().split("\\.");
    }
}