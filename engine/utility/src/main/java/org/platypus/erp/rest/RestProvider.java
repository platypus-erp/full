package org.platypus.erp.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ext.ContextResolver;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@ApplicationScoped
public class RestProvider {

    private final Set<Class<? extends ContextResolver<ObjectMapper>>> providers;

    public RestProvider() {
        providers = new HashSet<>();
    }

    public void addProvider(Class<? extends  ContextResolver<ObjectMapper>> provider){
        providers.add(provider);
    }

    public Set<Class<? extends ContextResolver<ObjectMapper>>> getAll(){
        System.out.println("getAll");
        return providers;
    }
}
