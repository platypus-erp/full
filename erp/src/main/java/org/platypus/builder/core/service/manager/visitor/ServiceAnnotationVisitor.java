package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.squareup.javapoet.ClassName;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
class ServiceAnnotationVisitor extends VoidVisitorAdapter<Void> {

    private Map<String, String> imports;
    private ClassName typeService;

    public ServiceAnnotationVisitor(Map<String, String> imports) {
        this.imports = imports;
    }

    @Override
    public void visit(SingleMemberAnnotationExpr n, Void arg) {
        n.getMemberValue().accept(this, null);
    }

    @Override
    public void visit(ClassOrInterfaceType n, Void arg) {
        typeService = ClassName.get(imports.get(n.getNameAsString()), n.getNameAsString());
    }

    public ClassName getTypeService() {
        return typeService;
    }
}
