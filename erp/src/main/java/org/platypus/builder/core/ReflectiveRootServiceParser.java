package org.platypus.builder.core;


import org.platypus.api.annotations.Service;
import org.platypus.builder.core.service.MetaInfoBusinessMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public class ReflectiveRootServiceParser {
    private final Map<String, MetaInfoBusinessMethod> rootMethod;

    public ReflectiveRootServiceParser(Map<String, MetaInfoBusinessMethod> rootMethod) {
        this.rootMethod = rootMethod;
    }

    public MetaInfoBusinessMethod parse(String moduleTechnicalName, Class<?> inheritClass) {
        List<String> methodNameInClass = Arrays.stream(inheritClass.getMethods())
                .map(Method::getName)
                .collect(Collectors.toList());



        System.out.println(inheritClass.getName());
        for (Class i : inheritClass.getInterfaces()){
            Service s = getAnno(i, Service.class);
            if (s != null){
                if (! methodNameInClass.contains(s.name())){
                    continue;
                }
                System.out.println(s.name());
                System.out.println(s.service().getName());
                Service.Super isuper = getAnno(i.getClasses()[0], Service.Super.class);
                System.out.println("Super == "+ i.getClasses()[0].getName());
                Method mToOveride = i.getMethods()[0];
                System.out.println(mToOveride);
            }
        }
        for (Method m : inheritClass.getMethods()){
            if (m.isAnnotationPresent(Service.Multi.class)){
                System.out.println(m.getDeclaringClass());
                System.out.println(m.getName());
            }
        }
        return null;
    }

    private <T extends Annotation> Optional<T> getAnnotation(Class<?> aClass, Class<T> aAnnotation) {
        return Optional.ofNullable(aClass.getAnnotation(aAnnotation));
    }

    private <T extends Annotation> T getAnno(Class<?> aClass, Class<T> aAnnotation) {
        return aClass.getAnnotation(aAnnotation);
    }

}
