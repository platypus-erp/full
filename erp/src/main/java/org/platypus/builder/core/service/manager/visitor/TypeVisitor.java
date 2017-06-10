package org.platypus.builder.core.service.manager.visitor;

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
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
class TypeVisitor extends GenericVisitorAdapter<TypeName, Map<String, String>> {

    @Override
    public TypeName visit(ClassOrInterfaceType n, Map<String, String> arg) {
        String pkg = arg.getOrDefault(n.getNameAsString(),
                MapJavaLang.javalangType.getOrDefault(n.getNameAsString(), ""));
        ClassName typeService = new TypeNameVisitor().visit(n, arg);
        List<TypeName> typeArg = new ArrayList<>();
        n.getTypeArguments().ifPresent(l -> l.forEach(v -> typeArg.add(v.accept(new TypeVisitor(), arg))));
        if (!typeArg.isEmpty()){
            return   ParameterizedTypeName.get(typeService, typeArg.toArray(new TypeName[typeArg.size()]));
        }
        return typeService;
    }

    @Override
    public TypeName visit(PrimitiveType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(ArrayType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(IntersectionType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(UnionType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(TypeParameter n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(UnknownType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(VoidType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(WildcardType n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TypeName visit(TypeExpr n, Map<String, String> arg) {
        throw new UnsupportedOperationException();
    }
}
