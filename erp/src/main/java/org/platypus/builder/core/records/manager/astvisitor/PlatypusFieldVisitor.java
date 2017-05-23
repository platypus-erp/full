package org.platypus.builder.core.records.manager.astvisitor;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.platypus.builder.core.Utils;

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
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassOrInterfaceType n, Void arg) {
        model.newField = n.getName().toString().equals("NewField");
        super.visit(n, arg);
    }

    @Override
    public void visit(MarkerAnnotationExpr n, Void arg) {
        if (Utils.isSupportedInterfaceByName(n.getName().getIdentifier())){
            model.annotatedWith = Utils.getInterfaceByName(n.getName().getIdentifier());
            model.annotatedWithName = n.getName().getIdentifier();
        }
        super.visit(n, arg);
    }

    @Override
    public void visit(NormalAnnotationExpr n, Void arg) {
        if (Utils.isSupportedInterfaceByName(n.getName().getIdentifier())){
            model.annotatedWith = Utils.getInterfaceByName(n.getName().getIdentifier());
            model.annotatedWithName = n.getName().getIdentifier();
        }
        super.visit(n, arg);
    }

    @Override
    public void visit(MemberValuePair n, Void arg) {
        if ("target".equals(n.getNameAsString())){
            model.classNameTarget = n.getValue().toString().replace(".class", "");
        }
        super.visit(n, arg);
    }

    @Override
    public void visit(SingleMemberAnnotationExpr n, Void arg) {
        if (Utils.isSupportedInterfaceByName(n.getName().getIdentifier())){
            model.annotatedWith = Utils.getInterfaceByName(n.getName().getIdentifier());
            model.annotatedWithName = n.getName().getIdentifier();
        }
        super.visit(n, arg);
    }
}
