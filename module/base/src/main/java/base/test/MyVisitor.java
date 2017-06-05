package base.test;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import org.platypus.api.annotations.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class MyVisitor extends VoidVisitorAdapter<Void> {

    Map<String, String> imports = new HashMap<>();
    ClassName model;

    @Override
    public void visit(ImportDeclaration n, Void arg) {
        System.out.println(n.getName());
        String str = n.getNameAsString();
        int idxPoint = str.lastIndexOf(".");
        imports.put(str.substring(idxPoint+1), str.substring(0, idxPoint));
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        super.visit(n, arg);
        ServiceAnnotationVisitor visitor = new ServiceAnnotationVisitor(imports);
        n.getAnnotationByClass(Service.class).ifPresent(a -> a.accept(visitor, null));
        model = visitor.getTypeService();
    }

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        MethodServiceVisitor v = new MethodServiceVisitor();
        n.accept(v, imports);
    }
}
