package org.platypus.buildin;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/05/17.
 */
public class DefaultMap<K, V> extends HashMap<K, V> {

    private final Supplier<V> supplier;

    public DefaultMap(Supplier<V> supplier){
        super();
        this.supplier = supplier;
    }

    @Override
    public V get(Object key) {
        return super.getOrDefault(key, supplier.get());
    }
}
