package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
class MethodServiceVisitor extends GenericVisitorAdapter<MethodSpec.Builder, Map<String, String>> {

    @Override
    public MethodSpec.Builder visit(MethodDeclaration n, Map<String, String> arg) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder(n.getNameAsString())
                .addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC)
                .returns(n.getType().accept(new TypeVisitor(), arg));

        n.getParameters().forEach(p -> builder.addParameter(p.accept(new ParameterVisitor(), arg).build()));
        return builder;
    }
}
