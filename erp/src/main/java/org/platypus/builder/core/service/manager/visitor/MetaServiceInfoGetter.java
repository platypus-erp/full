package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.squareup.javapoet.ClassName;
import org.platypus.api.annotations.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
class MetaServiceInfoGetter extends VoidVisitorAdapter<Void> {

    Map<String, String> imports = new HashMap<>();
    ClassName model;

    private MetaServiceInfoGetter() {}

    public static MetaSeviceInfo get(CompilationUnit cu){
        MetaServiceInfoGetter myVisitor = new MetaServiceInfoGetter();
        cu.accept(myVisitor, null);
        return new MetaSeviceInfo(myVisitor.imports, myVisitor.model);
    }

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
}
