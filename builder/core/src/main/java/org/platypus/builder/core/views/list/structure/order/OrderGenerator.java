package org.platypus.builder.core.views.list.structure.order;

import org.platypus.builder.core.views.list.structure.ListView;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.Integer.compare;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class OrderGenerator {

    private Map<String, ColumnTree> map = new HashMap<>();
    private int currentOrder = 0;

    public Optional<String> registerColumn(Element element) {
        Optional<String> result = Optional.empty();
        String colId = element.getAttribute("id");
        System.out.println(colId + " -- nombre d'after = " + element.getElementsByTagName("after").getLength());
        System.out.println(colId + " -- nombre de before = " + element.getElementsByTagName("before").getLength());
        if (element.getElementsByTagName("before").getLength() == 1) {
            Element before = Element.class.cast(element.getElementsByTagName("before").item(0));
            ColumnTree targetColumn = get(before.getAttribute("target-id"));
            if (targetColumn == null) {
                result = Optional.of("before target-id [" + before.getAttribute("target-id") + "] for the column [" + colId + "]");
            } else {
                ColumnTree column = targetColumn.addBefore(colId);
                map.put(colId, column);
            }
        } else if (element.getElementsByTagName("after").getLength() == 1) {
            Element before = Element.class.cast(element.getElementsByTagName("after").item(0));
            ColumnTree targetColumn = get(before.getAttribute("target-id"));
            if (targetColumn == null) {
                result = Optional.of("after target-id [" + before.getAttribute("target-id") + "] for the column [" + colId + "]");
            } else {
                ColumnTree column = targetColumn.addAfter(colId);
                map.put(colId, column);
            }
        } else {
            currentOrder = currentOrder + 100;
            map.put(colId, new ColumnTree(colId, currentOrder));
        }
        return result;
    }

    private ColumnTree get(String attribute) {
        return map.get(attribute);
    }

    public ListView applyOrder(ListView listView) {
        OrderNormalizer normalizer = new OrderNormalizer();
        listView.getDataTableView().getAllColumns().stream()
                .peek(column -> column.setOrder(map.get(column.getId()).getOrder()))
                .sorted((c1, c2) -> compare(c1.getOrder(), c2.getOrder()))
                .forEach(column -> column.setOrder(normalizer.getOrder()));
        return listView;
    }
}
