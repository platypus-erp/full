package base.test;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.TypeExpr;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.IntersectionType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.type.UnionType;
import com.github.javaparser.ast.type.UnknownType;
import com.github.javaparser.ast.type.VoidType;
import com.github.javaparser.ast.type.WildcardType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

import java.util.List;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
public class TypeVisitor extends VoidVisitorAdapter<Map<String, String>> {

    private ClassName typeService;



    @Override
    public void visit(ClassOrInterfaceType n, Map<String, String> arg) {
        String pkg = arg.get(n.getNameAsString());
        List<TypeName> typeArg;
        n.getTypeArguments().ifPresent(l -> l.forEach(v -> {
            TypeVisitor tv = new TypeVisitor();
            v.accept(tv, arg);

        }));


        n.getAnnotations().forEach(p -> p.accept(this, arg));
        n.getComment().ifPresent(l -> l.accept(this, arg));
    }

    @Override
    public void visit(PrimitiveType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(ArrayType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(IntersectionType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(UnionType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(TypeParameter n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(UnknownType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(VoidType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(WildcardType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(TypeExpr n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }
}
