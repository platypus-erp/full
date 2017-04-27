package org.platypus.framework.maven.views.list;

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
public class ListViewRegistry {

    private Map<String, ListView> listView = new HashMap<>();


    public ListView getListView(String id, String target) {
        ListView generator = listView.get(id);
        if (generator == null) {
            generator = new ListView(target, id);
            listView.put(target, generator);
        }
        return generator;
    }
}
