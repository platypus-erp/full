package org.platypus.builder.core.service.manager.astvisitor;

import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class PlatypusModelAnnotationVisitor extends VoidVisitorAdapter<Void>{

    private String modelName;
    public static String getName(AnnotationExpr annotationExpr){
        PlatypusModelAnnotationVisitor self = new PlatypusModelAnnotationVisitor();
        annotationExpr.accept(self, null);
        return self.modelName;
    }
    @Override
    public void visit(NormalAnnotationExpr n, Void arg) {
        n.getPairs().get(0).getValue().accept(this, arg);
    }

    @Override
    public void visit(SingleMemberAnnotationExpr n, Void arg) {
        n.getMemberValue().accept(this, arg);
    }

    @Override
    public void visit(final StringLiteralExpr n, Void arg) {
        modelName = n.getValue();
    }
}
