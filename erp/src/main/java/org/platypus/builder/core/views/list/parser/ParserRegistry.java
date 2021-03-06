package org.platypus.builder.core.views.list.parser;


import org.platypus.builder.core.views.list.structure.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ParserRegistry {

    private List<ListView> listViews = new ArrayList<>();

    public List<ListView> getListViews() {
        return listViews;
    }

    public void addListView(ListView listView) {
        listViews.add(Objects.requireNonNull(listView));
//        MvnLogger.logger.info("=------------add list view ["+listView.getTarget()+"]-----------------=");
    }
}
