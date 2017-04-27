package org.platypus.erp.entity;

import java.util.HashMap;
import java.util.Optional;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public enum EntityRegistry {
    INSTANCE;
    private final HashMap<String, Class<? extends AbstractEntity>> entities;

    EntityRegistry() {
        entities = new HashMap<>();
    }

    public <E extends AbstractEntity> void put(String key, Class<E> clazz) {
        entities.put(key, clazz);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public<E extends AbstractEntity> Optional<Class<E>> getClass(String key) {
        return Optional.ofNullable((Class<E>) entities.get(key));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public<E extends AbstractEntity> Class<E> getSafeClass(String key) {
        return (Class<E>) entities.get(key);
    }

    public <E extends AbstractEntity> Optional<String> getName(Class<E> clazz) {
        return entities.entrySet().stream()
                .filter(e -> e.getValue().equals(clazz))
                .map(e -> e.getKey())
                .findFirst();
    }

    public <E extends AbstractEntity> String getSafeName(Class<E> clazz) {
        return entities.entrySet().stream()
                .filter(e -> e.getValue().equals(clazz))
                .map(e -> e.getKey())
                .findFirst().orElseThrow(() -> new RuntimeException("class not found "+clazz.getSimpleName()));
    }
}
