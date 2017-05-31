package org.platypus.plugin.generator.jpa.internal.recordImpl;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import org.platypus.api.fields.Bool;

import javax.lang.model.element.Modifier;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordImplSetterGenerator extends FieldGenerator {

    public BasicFieldRecordImplSetterGenerator() {
        super(f -> f.readonly() == Bool.TRUE);
    }

    @Override
    protected Optional<MethodSpec> getMethod(String name, TypeName field) {
        return Optional.of(MethodSpec.methodBuilder(name)
                .addParameter(ParameterSpec.builder(field, name, Modifier.FINAL).build())
                .addCode("getOrDefault().$N($N);\n", name, name)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
}
