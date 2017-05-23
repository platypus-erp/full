package org.platypus.erp.rest.payload;

import org.platypus.erp.entity.AbstractEntity;
import org.platypus.erp.entity.EntityRegistry;
import org.platypus.erp.entity.Identifiable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@XmlRootElement(name = "payload")
public class PayLoad implements RestPayLoad {

    public static final String THE_ENTITY_SHOULD_NEVER_BE_NULL = "The entity should never be null";
    @XmlAttribute
    private final Map<String, Object> entities = new HashMap<>();
    private final List<String> keys = new ArrayList<>();
    @XmlAttribute
    private long id;
    @XmlAttribute
    private Object entity;

    public PayLoad() {
    }

    public PayLoad(Identifiable entity) {
        this(Objects.requireNonNull(entity, THE_ENTITY_SHOULD_NEVER_BE_NULL).getId());
        this.entity = entity;
    }

    public PayLoad(long id) {
        this.id = id;
    }

    @Override
    public <T extends AbstractEntity> T getEntity() {
        return (T) entity;
    }

    @Override
    public <T extends AbstractEntity> void setEntity(T entity) {
        Objects.requireNonNull(entity, THE_ENTITY_SHOULD_NEVER_BE_NULL);
        this.id = entity.getId();
        this.entity = entity;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void put(String key, Object entity) {
        Objects.requireNonNull(entity, THE_ENTITY_SHOULD_NEVER_BE_NULL);
        keys.add(key);
        entities.put(key, entity);
    }

    public <E extends AbstractEntity> void addEntity(E entity) {
        Objects.requireNonNull(entity, THE_ENTITY_SHOULD_NEVER_BE_NULL);
        keys.add(entity.getTableName());
        entities.put(entity.getTableName(), entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends AbstractEntity> Optional<T> get(Class<T> aClass) {
        Objects.requireNonNull(aClass, THE_ENTITY_SHOULD_NEVER_BE_NULL);
        return Optional.ofNullable(aClass.cast(entities.get(EntityRegistry.INSTANCE.getName(aClass).get())));
    }

    @Override
    public List<String> getEntities() {
        return Collections.unmodifiableList(keys);
    }
}
