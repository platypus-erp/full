package org.platypus.builder.core.records.manager.astvisitor;

import com.squareup.javapoet.ClassName;
import org.platypus.api.Bool;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class FieldModel {

    ClassName annotatedWith;
    String annotatedWithName;
    String name;
    boolean newField;
    Bool readonly;
    String classNameTarget;

    public ClassName getAnnotatedWith() {
        return annotatedWith;
    }

    public String getName() {
        return name;
    }

    public boolean isNewField() {
        return newField;
    }

    public Bool getReadonly() {
        return readonly;
    }

    public String getClassNameTarget() {
        return classNameTarget;
    }

    @Override
    public String toString() {
        return "FieldModel{" +
                "\nannotatedWith=" + annotatedWith +
                "\nannotatedWithName=" + annotatedWithName +
                "\nname='" + name + "'" +
                "\nnewField=" + newField +
                "\nreadonly=" + readonly +
                "\nclassNameTarget=" + classNameTarget +
                '}';
    }
}
