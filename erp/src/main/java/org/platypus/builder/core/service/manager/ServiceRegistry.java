package org.platypus.builder.core.service.manager;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.BaseModel;
import org.platypus.api.module.PlatypusCompleteModuleInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 15/06/17.
 */
public class ServiceRegistry {

    Map<ClassName, TypeSpec.Builder> services = new HashMap<>();


    public static ServiceRegistry init(String moduleName, Set<PlatypusCompleteModuleInfo> depends) {
        ServiceRegistry serviceRegistry = new ServiceRegistry();
        for (PlatypusCompleteModuleInfo depend : depends) {
            for (Map.Entry<Class<? extends BaseModel>, Class<?>> service : depend.getServices().entrySet()) {
                serviceRegistry.services.merge(ClassName.get(
                        service.getKey()),
                        newService(moduleName).addSuperinterface(ClassName.get(service.getValue())),
                        (c, t) -> t.addSuperinterface(ClassName.get(service.getValue()))
                );
            }
        }
        return serviceRegistry;
    }

    public void addServiceRoot(String moduleName, ClassName cls, TypeSpec typeSpec) {
        services.merge(cls,
                newService(moduleName).addMethod(typeSpec.methodSpecs.get(0)).addType(typeSpec),
                (c, t) -> t.addType(typeSpec).addMethod(typeSpec.methodSpecs.get(0))
        );
    }

    public Map<ClassName, TypeSpec.Builder> getServices() {
        return services;
    }

    private static TypeSpec.Builder newService(String moduleName) {
        return TypeSpec.interfaceBuilder(StringUtils.capitalize(moduleName) + "Service");
    }
}
