package org.platypus.builder.core.service.manager.visitor;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.annotations.Service;

import javax.lang.model.element.Modifier;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
class ServiceBuilder extends GenericVisitorAdapter<Optional<TypeSpec>, MetaSeviceInfo> {

    @Override
    public Optional<TypeSpec> visit(MethodDeclaration n, MetaSeviceInfo arg) {
        if (n.getAnnotationByClass(Override.class).isPresent()){
            return Optional.empty();
        }
        AnnotationSpec annoService = null;
        if (n.getAnnotationByClass(Service.Multi.class).isPresent()){
            annoService = AnnotationSpec.builder(Service.Multi.class).build();
        }
        if (n.getAnnotationByClass(Service.One.class).isPresent()){
            annoService = AnnotationSpec.builder(Service.One.class).build();
        }
        if (n.getAnnotationByClass(Service.Empty.class).isPresent()){
            annoService = AnnotationSpec.builder(Service.Empty.class).build();
        }
        if (annoService == null){
            return Optional.empty();
        }
        MethodSpec.Builder newServiceMethod = n.accept(new MethodServiceVisitor(), arg.imports)
                .addAnnotation(annoService);
        TypeSpec.Builder serviceType = TypeSpec.interfaceBuilder(StringUtils.capitalize(n.getNameAsString()));
        serviceType.addAnnotation(AnnotationSpec.builder(FunctionalInterface.class).build());
        serviceType.addAnnotation(
                AnnotationSpec.builder(Service.class)
                        .addMember("value", "$T.class", arg.model)
                        .build());

        TypeSpec superService = TypeSpec.interfaceBuilder("Super")
                .addAnnotation(AnnotationSpec.builder(FunctionalInterface.class).build())
                .addAnnotation(AnnotationSpec.builder(Service.Super.class).build())
                .addMethod(newServiceMethod.build())
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .build();
        serviceType.addType(superService);

        newServiceMethod.addParameter(
                ParameterSpec.builder(ClassName.get("", "Super"), "sup").build());

        serviceType.addMethod(newServiceMethod.build());

        return Optional.of(serviceType.build());
    }
}
