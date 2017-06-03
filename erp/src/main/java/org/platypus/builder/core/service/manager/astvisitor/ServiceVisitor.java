package org.platypus.builder.core.service.manager.astvisitor;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class ServiceVisitor extends VoidVisitorAdapter<Void> {

    String className;
    String pkg;
    boolean isRootModel;
    boolean isValidModel;
    String modelName;

    Map<String, Set<BusinessMethodModel>> fields = new HashMap<>();

    private ServiceVisitor() {}

    public static ServiceVisitor getInfo(CompilationUnit cu) {
        ServiceVisitor v = new ServiceVisitor();
        cu.accept(v, null);
        return v;
    }

    @Override
    public void visit(CompilationUnit n, Void arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(PackageDeclaration n, Void arg) {
        pkg = n.getName().asString();
        super.visit(n, arg);
    }



    @Override
    public void visit(FieldDeclaration n, Void arg) {
        BusinessMethodModel fieldModel = PlatypusBusinessVisitor.getField(n);
        Set<BusinessMethodModel> sets = fields.getOrDefault(fieldModel.annotatedWithName, new HashSet<>());
        sets.add(fieldModel);
        fields.put(fieldModel.annotatedWithName, sets);
        super.visit(n, arg);
    }


    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        className = n.getName().getIdentifier();

        super.visit(n, arg);
    }

    public boolean isValidModel() {
        return isValidModel;
    }
}
