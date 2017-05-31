package org.platypus.erp.data.demo.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.platypus.erp.data.demo.DemoDataLoader;
import org.platypus.erp.data.demo.DemoDataLoaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.IOException;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class JsonDemoDataLoader implements DemoDataLoader {
    private final Logger LOG = LoggerFactory.getLogger(JsonDemoDataLoader.class);
    ObjectMapper mapper = new ObjectMapper();
    @PersistenceContext
    private EntityManager em;

    public void load(DemoDataLoaderBuilder builder) {
        try {
            if (builder.getDataType().isCollectionLikeType()) {
//                List<AbstractEntity> datas = mapper.readValue(builder.getDatas(), builder.getDataType());
//                datas.forEach(data -> em.persist(data));
            } else {
                Object data = mapper.readValue(builder.getDatas(), builder.getDataType());
                em.persist(data);
            }
        } catch (IOException e) {
            LOG.error("Error when parsing demo-test.json for partner", e);
        }
    }
}
