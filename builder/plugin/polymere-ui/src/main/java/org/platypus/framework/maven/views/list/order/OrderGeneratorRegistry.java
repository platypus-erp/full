package org.platypus.framework.maven.views.list.order;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class OrderGeneratorRegistry {

    private Map<String, OrderGenerator> generators = new HashMap<>();


    public OrderGenerator getGenerator(String target) {
        OrderGenerator generator = generators.get(target);
        if (generator == null) {
            generator = new OrderGenerator();
            generators.put(target, generator);
        }
        return generator;
    }
}
