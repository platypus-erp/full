package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.squareup.javapoet.ParameterSpec;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
class ParameterVisitor extends GenericVisitorAdapter<ParameterSpec.Builder, Map<String, String>> {

    @Override
    public ParameterSpec.Builder visit(Parameter n, Map<String, String> arg) {
        ParameterSpec.Builder b = ParameterSpec.builder(
                n.getType().accept(new TypeVisitor(), arg),
                n.getNameAsString()
        );
        return b;
    }



}
