package org.platypus.erp.rest.payload;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.platypus.api.Record;
import org.platypus.erp.entity.EntityRegistry;
import org.platypus.erp.exceptions.TotoJsonMappingException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface RestPayLoad {

    static <E extends RestPayLoad> E fill(JsonNode node, Supplier<E> supplier) {
        //TODO check content of node before doing somethings
        //TODO return a payload with error
        E payload = supplier.get();
        payload.setId(node.get("id").asLong(0));
        ObjectMapper mapper = new ObjectMapper();
        Class<Record> clazz = EntityRegistry.INSTANCE.getSafeClass(node.get("entity").get("tableName").asText());
        try {
            payload.setEntity(mapper.readValue(mapper.writeValueAsString(node.get("entity")), clazz));
        } catch (IOException e) {
            throw new TotoJsonMappingException(e);
        }
        Iterator<Map.Entry<String, JsonNode>> it = node.get("entities").fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mm = it.next();
            Class clazz2 = EntityRegistry.INSTANCE.getSafeClass(mm.getKey());
            try {
                payload.put(mm.getKey(), mapper.readValue(mapper.writeValueAsString(mm.getValue()), clazz2));
            } catch (IOException e) {
                throw new TotoJsonMappingException(e);
            }
        }
        return payload;
    }

    static <E extends RestPayLoad> void unFill(JsonGenerator gen, E payLoad) {
        try {
            gen.writeStartObject();
            gen.writeStringField("id", String.valueOf(payLoad.getId()));
            gen.writeObjectField("entity", payLoad.getEntity());
            Map<String, Object> map = new HashMap<>(payLoad.getEntities().size());
            payLoad.getEntities().stream()
                    .filter(e -> EntityRegistry.INSTANCE.getClass(e).isPresent())
                    .forEach(e -> map.put(e, payLoad.get(EntityRegistry.INSTANCE.getSafeClass(e))));
            gen.writeObjectField("entities", map);
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * THIS METHOD IS EAVY UNCHCKED
     * TODO find a other way to do this crazy stuff
     *
     * @param <T>
     * @return
     */
    <T extends Record> T getEntity();

    <T extends Record> void setEntity(T entity);

    long getId();

    void setId(long id);

    void put(String key, Object entity);

    @SuppressWarnings("unchecked")
    <T extends Record> Optional<T> get(Class<T> aClass);

    List<String> getEntities();
}
