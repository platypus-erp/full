package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.squareup.javapoet.ClassName;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
class TypeNameVisitor extends GenericVisitorAdapter<ClassName, Map<String, String>> {

    @Override
    public ClassName visit(ClassOrInterfaceType n, Map<String, String> arg) {
        String pkg = arg.getOrDefault(n.getNameAsString(),
                MapJavaLang.javalangType.getOrDefault(n.getNameAsString(), ""));
        ClassName typeService = ClassName.get(pkg, n.getNameAsString());
        if (n.getScope().isPresent()){
            typeService = n.getScope().get().accept(this, arg).nestedClass(typeService.simpleName());
        }
        return typeService;
    }
}
