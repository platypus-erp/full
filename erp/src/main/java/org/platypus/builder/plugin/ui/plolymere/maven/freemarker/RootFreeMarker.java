package org.platypus.builder.plugin.ui.plolymere.maven.freemarker;

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
public interface RootFreeMarker {

    default Map<String, Object> getMap(){
        HashMap<String, Object> root = new HashMap<>(1);
        root.put("root", this);
        return root;
    }
}
