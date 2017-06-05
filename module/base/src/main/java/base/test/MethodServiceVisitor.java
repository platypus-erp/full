package base.test;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
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
public class MethodServiceVisitor extends VoidVisitorAdapter<Map<String, String>> {

    private ClassName typeService;

    @Override
    public void visit(MethodDeclaration n, Map<String, String> arg) {
        TypeVisitor tv = new TypeVisitor();
        n.getType().accept(tv, arg);
        super.visit(n, arg);
    }

    @Override
    public void visit(MarkerAnnotationExpr n, Map<String, String> arg) {

        super.visit(n, arg);
    }
}
