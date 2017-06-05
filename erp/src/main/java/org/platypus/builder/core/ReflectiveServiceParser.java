package org.platypus.builder.core;


import org.platypus.api.annotations.Service;
import org.platypus.builder.core.service.MetaInfoBusinessMethod;
import org.platypus.builder.core.service.MetaInfoBusinessMethodParam;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public class ReflectiveServiceParser {
    public List<MetaInfoBusinessMethod> parse(Class<?> serviceClass) {
        checkClassService(serviceClass);
        System.out.println(serviceClass);
        List<Method> methodService = new ArrayList<>(serviceClass.getDeclaredMethods().length);
        for (Class<?> i : serviceClass.getInterfaces()) {
            if (i.isAnnotationPresent(Service.class)) {
                for (Parameter p : i.getMethods()[0].getParameters()){
                    System.out.println(p.getName());
                }
                methodService.add(i.getMethods()[0]);
            }
        }
        for (Method dm : serviceClass.getDeclaredMethods()){
            if (dm.isAnnotationPresent(Service.Multi.class)){
                boolean isOverride = false;
                for (Method m : new ArrayList<>(methodService)){
                    if (isOverrideMethod(m, dm)){
                        isOverride = true;
                    }
                }
                if (! isOverride){
                    methodService.add(dm);
                }
            } else if (dm.isAnnotationPresent(Service.One.class)){
                boolean isOverride = false;
                for (Method m : new ArrayList<>(methodService)){
                    if (isOverrideMethod(m, dm)){
                        isOverride = true;
                    }
                }
                if (! isOverride){
                    methodService.add(dm);
                }
            } else if (dm.isAnnotationPresent(Service.Empty.class)){
                boolean isOverride = false;
                for (Method m : new ArrayList<>(methodService)){
                    if (isOverrideMethod(m, dm)){
                        isOverride = true;
                    }
                }
                if (! isOverride){
                    methodService.add(dm);
                }
            }
        }
        return methodService.stream()
                .map(m -> toMetaInfo(serviceClass, m))
                .collect(Collectors.toList());
    }

    private MetaInfoBusinessMethod toMetaInfo(Class<?> inheritClass, Method method){
        MetaInfoBusinessMethod m = new MetaInfoBusinessMethod(
                inheritClass.getPackage().getName(),
                inheritClass.getSimpleName(),
                method.getName(),
                method.getReturnType().getPackage().getName(),
                method.getReturnType().getSimpleName());
        for (Parameter p : method.getParameters()){
            m.params.add(new MetaInfoBusinessMethodParam(
                    p.getType().getPackage().getName(),
                    getDeclaredClass(p.getType()),
                    p.getName()
            ));
        }
        return m;
    }

    private List<String> getDeclaredClass(Class<?> clazz){
        ArrayList<String> d = new ArrayList<>(5);
        if (clazz.getDeclaringClass() != null){
            d.addAll(getDeclaredClass(clazz.getDeclaringClass()));
        }
        d.add(clazz.getSimpleName());
        return d;
    }



    private boolean isOverrideMethod(Method ref, Method current){
        if (! ref.getName().equals(current.getName())){
            return false;
        }
        if (! ref.getReturnType().equals(current.getReturnType())
                || ! ref.getReturnType().isAssignableFrom(current.getReturnType())){
            return false;
        }
        return equalParamTypes(ref.getParameterTypes(), current.getParameterTypes());
    }

    private boolean equalParamTypes(Class<?>[] params1, Class<?>[] params2) {
        /* Avoid unnecessary cloning */
        if (params1.length == params2.length) {
            for (int i = 0; i < params1.length; i++) {
                if (params1[i] != params2[i])
                    return false;
            }
            return true;
        }
        return false;
    }

    private void checkClassService(Class<?> inheritClass) {
        if (!(Modifier.isPublic(inheritClass.getModifiers())
                && !Modifier.isAbstract(inheritClass.getModifiers()))) {
            throw new IllegalArgumentException(
                    "The class[" +
                            inheritClass.getName()
                            + "] should be public and non abstract");
        }
    }

}
