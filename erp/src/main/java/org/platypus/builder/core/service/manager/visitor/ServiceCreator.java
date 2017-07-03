package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class ServiceCreator extends VoidVisitorAdapter<MetaSeviceInfo> {

    private Map<ClassName, List<TypeSpec>> services = new HashMap<>();
    MetaSeviceInfo metaSeviceInfo;
    private ServiceCreator() {}

    public static ServiceCreator get(CompilationUnit cu) {
        ServiceCreator v = new ServiceCreator();
        v.metaSeviceInfo = MetaServiceInfoGetter.get(cu);
        if (v.isValid()){
            cu.accept(v, MetaServiceInfoGetter.get(cu));
        }
        return v;
    }

    public boolean isValid(){
       return metaSeviceInfo.model != null;
    }

    public Map<ClassName, List<TypeSpec>> getServices() {
        return services;
    }

    @Override
    public void visit(MethodDeclaration n, MetaSeviceInfo arg) {
        List<TypeSpec> l = services.computeIfAbsent(arg.model, c -> new ArrayList<>());
        n.accept(new ServiceBuilder(), arg).ifPresent(l::add);
    }
}
