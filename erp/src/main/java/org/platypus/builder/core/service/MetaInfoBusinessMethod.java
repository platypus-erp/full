package org.platypus.builder.core.service;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class MetaInfoBusinessMethod {

    public final String pkgName;
    public final String methodName;
    public final String className;
    public final Class<? extends Annotation> anno;
    public final List<MetaInfoBusinessMethodParam> params;

    public MetaInfoBusinessMethod(String pkgName, String className, String methodName, Class<? extends Annotation> anno, List<MetaInfoBusinessMethodParam> params) {
        this.pkgName = pkgName;
        this.className = className;
        this.methodName = methodName;
        this.anno = anno;
        this.params = Collections.unmodifiableList(params);
    }

    @Override
    public String toString() {
        return pkgName + '.' + className + '.' + methodName;
    }
}
