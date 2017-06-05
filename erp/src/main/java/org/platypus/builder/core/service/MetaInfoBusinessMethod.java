package org.platypus.builder.core.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 02/06/17.
 */
public class MetaInfoBusinessMethod {
    public final String className;
    public final String pkgClassName;
    public final String methodName;
    public final String pkgReturnType;
    public final String returnType;
    public final List<MetaInfoBusinessMethodParam> params;

    public MetaInfoBusinessMethod(String pkgClassName,String className,String methodName,
                                  String pkgReturnType,
                                  String returnType) {
        this.pkgClassName = pkgClassName;
        this.className = className;
        this.methodName = methodName;
        this.pkgReturnType = pkgReturnType;
        this.returnType = returnType;
        this.params = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "MetaInfoBusinessMethod{" +
                "methodName='" + methodName + '\'' +
                ", pkgReturnType='" + pkgReturnType + '\'' +
                ", returnType='" + returnType + '\'' +
                ", params=" + params +
                '}';
    }
}
