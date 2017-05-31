package org.platypus.builder.core.views.list.structure.column;

import org.apache.commons.lang3.StringUtils;
import org.platypus.builder.core.views.list.structure.order.OrderGenerator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Optional;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public abstract class ColumnBuilder<T extends AbstractColumn> {

    private Class<T> clazz;
    private OrderGenerator orderGenerator;

    public ColumnBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }

    private T getInstance() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public T buildFromNode(Node node, String target) {
        T instance = getInstance();
        if (instance.getColumnType().getXmlName().equals(node.getNodeName())) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = Element.class.cast(node);
                instance = fillGenericAttribut(instance, e, target);
                buildColumn(instance, e);
            }
        }
        return instance;
    }

    protected abstract void buildColumn(T col, Element node);

    protected final T fillGenericAttribut(T col, Element element, String target) {
        Optional<String> errMsg = orderGenerator.registerColumn(element);
        if (errMsg.isPresent()) {
            throw new ReferencialPositionException(errMsg.get());
        }
        col.setId(element.getAttribute("id"));
        col.setPropertyName(element.getAttribute("property"));

        String headerKey = element.getAttribute("header-label");
        //TODO concatenation target + _ + propertyName
        col.setHeaderLabelKey(StringUtils.defaultIfBlank(headerKey, target + "_" + col.getPropertyName()));

        col.setActif(Boolean.parseBoolean(element.getAttribute("actif")));
        return col;
    }

    public ListViewColumn.ColumnType validNodeName() {
        return getInstance().getColumnType();
    }

    public final ColumnBuilder<T> withGenerator(OrderGenerator orderGenerator) {
        this.orderGenerator = orderGenerator;
        return this;
    }
}
