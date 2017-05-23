package org.platypus.plugin.generator.jpa.internal.recordImpl;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;

import javax.lang.model.element.Modifier;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordImplGetterGenerator extends FieldGenerator{

    public BasicFieldRecordImplGetterGenerator() {
        super(f -> false);
    }

    @Override
    protected Optional<MethodSpec> getMethod(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder(name)
                .returns(field)
                .addCode("return getOrDefault().$N();\n", name)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
}
