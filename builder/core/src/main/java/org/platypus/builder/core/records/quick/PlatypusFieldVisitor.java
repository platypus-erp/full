package org.platypus.builder.core.records.quick;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class PlatypusFieldVisitor extends VoidVisitorAdapter<Void> {
    FieldModel model = new FieldModel();

    public static FieldModel getField(FieldDeclaration fieldDeclaration) {
        PlatypusFieldVisitor v = new PlatypusFieldVisitor();
        fieldDeclaration.accept(v, null);
        return v.model;

    }

    @Override
    public void visit(VariableDeclarator n, Void arg) {
        model.name = n.getName().getIdentifier();
    }

    @Override
    public void visit(MarkerAnnotationExpr n, Void arg) {
        model.annotatedWith = Utils.getInterfaceByName(n.getName().getIdentifier());
    }

    @Override
    public void visit(NormalAnnotationExpr n, Void arg) {
        model.annotatedWith = Utils.getInterfaceByName(n.getName().getIdentifier());
    }

    @Override
    public void visit(SingleMemberAnnotationExpr n, Void arg) {
        model.annotatedWith = Utils.getInterfaceByName(n.getName().getIdentifier());
    }
}
