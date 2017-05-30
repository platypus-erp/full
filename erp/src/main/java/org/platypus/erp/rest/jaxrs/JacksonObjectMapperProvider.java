package org.platypus.erp.rest.jaxrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.platypus.erp.rest.payload.PayloadModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;
    private final Logger LOG = LoggerFactory.getLogger(JacksonObjectMapperProvider.class);
    @Inject
    private PayloadModule payloadModule;

    public JacksonObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    private ObjectMapper createDefaultMapper() {
        LOG.info("Inject in Jax-RS provider works [{}]", payloadModule != null);
        ObjectMapper mapper = new ObjectMapper();
//            mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new PayloadModule());
        return mapper;
    }

}
