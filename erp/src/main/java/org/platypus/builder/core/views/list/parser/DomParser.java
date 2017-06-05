package org.platypus.builder.core.views.list.parser;

import org.platypus.builder.core.views.list.DataTableView;
import org.platypus.builder.core.views.list.ListViewRegistry;
import org.platypus.builder.core.views.list.SchemaValidator;
import org.platypus.builder.core.views.list.structure.ListView;
import org.platypus.builder.core.views.list.structure.Structure;
import org.platypus.builder.core.views.list.structure.headerfilter.Filter;
import org.platypus.builder.core.views.list.structure.headerfilter.GroupFilter;
import org.platypus.builder.core.views.list.structure.headerfilter.HeaderFilter;
import org.platypus.builder.core.views.list.structure.order.OrderGenerator;
import org.platypus.builder.core.views.list.structure.order.OrderGeneratorRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.nio.file.Path;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class DomParser {
    private static final String NODE_ROOT_NAME = "toto-view";

    private SchemaValidator shemaValidator;
    private DocumentBuilderFactory documentBuilderFactory;
    private OrderGeneratorRegistry registry;
    private ListViewRegistry listViewRegistry;

    public DomParser(OrderGeneratorRegistry orderGeneratorRegistry) {
        listViewRegistry = new ListViewRegistry();
        registry = orderGeneratorRegistry;
        shemaValidator = new SchemaValidator();
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
    }

    public DomParserError parseListView(Path path) {
        DomParserError parserError = new DomParserError();
        try {
            DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(path.toFile());
            Element platypusListView = Element.class.cast(doc.getElementsByTagName(Structure.PLATYPUS_LIST_VIEW).item(0));
            String target = platypusListView.getAttribute(Structure.TARGET);

            ListView listView = listViewRegistry.getListView(platypusListView.getAttribute(Structure.ID), target)
                    .setDefaultFilterId(platypusListView.getAttribute("default-filter-id"))
                    .setHeaderFilter(parserHeaderFilter(doc))
                    .setDataTableView(parseDataTable(doc, target));
            parserError.setListView(listView);
        } catch (SAXException e) {
//            MvnLogger.logger.error(e);
            parserError.addSAXException(e);
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
//            MvnLogger.logger.error(e);
            parserError.addParserConfigurationException(e);
            throw new RuntimeException(e);
        } catch (IOException e) {
//            MvnLogger.logger.error(e);
            parserError.addIOException(e);
            throw new RuntimeException(e);
        }
        return parserError;
    }

    private HeaderFilter parserHeaderFilter(Document doc) {
        NodeList headerFilters = doc.getElementsByTagName(Structure.HEADER_FILTERS);
        NodeList nodeList = headerFilters.item(0).getChildNodes();
        HeaderFilter headerFilter = new HeaderFilter();
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node currentNode = nodeList.item(count);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node methodName and value
                System.out.println("\nNode Name =" + currentNode.getNodeName() + " [OPEN]");
                if (Structure.GROUP_FILTER.equals(currentNode.getNodeName())) {
                    Element e = Element.class.cast(currentNode);
                    GroupFilter groupFilter = new GroupFilter(
                            e.getAttribute(Structure.LABEL),
                            e.getAttribute(Structure.LABEL_POSITION));
                    NodeList filtersNode = e.getElementsByTagName(Structure.FILTER);
                    for (int count2 = 0; count2 < filtersNode.getLength(); count2++) {
                        Node currentFilter = nodeList.item(count);
                        if (currentFilter.getNodeType() == Node.ELEMENT_NODE) {
                            Element filterElement = Element.class.cast(currentFilter);
                            groupFilter.addFilter(new Filter(
                                    filterElement.getAttribute(Structure.FILTER_ID),
                                    filterElement.getAttribute(Structure.LABEL)));
                        }
                    }
                    headerFilter.addGroupFilter(groupFilter);
                }
                if (Structure.FILTER.equals(currentNode.getNodeName())) {
                    Element e = Element.class.cast(currentNode);
                    headerFilter.addFilter(new Filter(
                            e.getAttribute(Structure.FILTER_ID),
                            e.getAttribute(Structure.LABEL)));
                }
                System.out.println("Node Name =" + currentNode.getNodeName() + " [CLOSE]");

            }
        }
        return headerFilter;
    }

    private DataTableView parseDataTable(Document doc, String target) {
        Element list = Element.class.cast(doc.getElementsByTagName(Structure.LIST).item(0));
        DataTableView dataTableView = new DataTableView(list.getAttribute(Structure.ID), target)
                .setListType(list.getAttribute(Structure.TYPE))
                .setPageSize(list.getAttribute(Structure.PAGE_SIZE))
                .setTitle(list.getAttribute(Structure.TITLE));

        NodeList columns = doc.getElementsByTagName(Structure.COLUMNS);
        NodeList nodeList = columns.item(0).getChildNodes();
        OrderGenerator orderGenerator = registry.getGenerator(target);
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node currentNode = nodeList.item(count);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node methodName and value
                System.out.println("\nNode Name =" + currentNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + currentNode.getTextContent());
                dataTableView.addColumn(
                        ColumnBuilderFactory.getBuilder(currentNode.getNodeName())
                                .withGenerator(orderGenerator)
                                .buildFromNode(currentNode, target));

                System.out.println("Node Name =" + currentNode.getNodeName() + " [CLOSE]");

            }
        }
        return dataTableView;
    }
}
