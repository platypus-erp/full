package org.platypus.builder.core.records.quick;

import com.squareup.javapoet.ClassName;

import java.lang.annotation.Annotation;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class FieldModel {

    ClassName annotatedWith;
    String name;

    @Override
    public String toString() {
        return "FieldModel{" +
                "annotatedWith=" + annotatedWith +
                ", name='" + name + '\'' +
                '}';
    }
}
