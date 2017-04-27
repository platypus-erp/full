package org.platypus.framework.maven.parser;

import org.platypus.framework.maven.shema.SchemaValidator;
import org.platypus.framework.maven.views.list.DataTableView;
import org.platypus.framework.maven.views.list.ListView;
import org.platypus.framework.maven.views.list.ListViewRegistry;
import org.platypus.framework.maven.views.list.headerfilter.Filter;
import org.platypus.framework.maven.views.list.headerfilter.GroupFilter;
import org.platypus.framework.maven.views.list.headerfilter.HeaderFilter;
import org.platypus.framework.maven.views.list.order.OrderGenerator;
import org.platypus.framework.maven.views.list.order.OrderGeneratorRegistry;
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

import static org.platypus.framework.maven.parser.ColumnBuilderFactory.getBuilder;
import static org.platypus.framework.maven.views.list.structure.Structure.COLUMNS;
import static org.platypus.framework.maven.views.list.structure.Structure.FILTER;
import static org.platypus.framework.maven.views.list.structure.Structure.FILTER_ID;
import static org.platypus.framework.maven.views.list.structure.Structure.GROUP_FILTER;
import static org.platypus.framework.maven.views.list.structure.Structure.HEADER_FILTERS;
import static org.platypus.framework.maven.views.list.structure.Structure.ID;
import static org.platypus.framework.maven.views.list.structure.Structure.LABEL;
import static org.platypus.framework.maven.views.list.structure.Structure.LABEL_POSITION;
import static org.platypus.framework.maven.views.list.structure.Structure.LIST;
import static org.platypus.framework.maven.views.list.structure.Structure.PAGE_SIZE;
import static org.platypus.framework.maven.views.list.structure.Structure.PLATYPUS_LIST_VIEW;
import static org.platypus.framework.maven.views.list.structure.Structure.TARGET;
import static org.platypus.framework.maven.views.list.structure.Structure.TITLE;
import static org.platypus.framework.maven.views.list.structure.Structure.TYPE;

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
            Element platypusListView = Element.class.cast(doc.getElementsByTagName(PLATYPUS_LIST_VIEW).item(0));
            String target = platypusListView.getAttribute(TARGET);

            ListView listView = listViewRegistry.getListView(platypusListView.getAttribute(ID), target)
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
        NodeList headerFilters = doc.getElementsByTagName(HEADER_FILTERS);
        NodeList nodeList = headerFilters.item(0).getChildNodes();
        HeaderFilter headerFilter = new HeaderFilter();
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node currentNode = nodeList.item(count);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node name and value
                System.out.println("\nNode Name =" + currentNode.getNodeName() + " [OPEN]");
                if (GROUP_FILTER.equals(currentNode.getNodeName())) {
                    Element e = Element.class.cast(currentNode);
                    GroupFilter groupFilter = new GroupFilter(
                            e.getAttribute(LABEL),
                            e.getAttribute(LABEL_POSITION));
                    NodeList filtersNode = e.getElementsByTagName(FILTER);
                    for (int count2 = 0; count2 < filtersNode.getLength(); count2++) {
                        Node currentFilter = nodeList.item(count);
                        if (currentFilter.getNodeType() == Node.ELEMENT_NODE) {
                            Element filterElement = Element.class.cast(currentFilter);
                            groupFilter.addFilter(new Filter(
                                    filterElement.getAttribute(FILTER_ID),
                                    filterElement.getAttribute(LABEL)));
                        }
                    }
                    headerFilter.addGroupFilter(groupFilter);
                }
                if (FILTER.equals(currentNode.getNodeName())) {
                    Element e = Element.class.cast(currentNode);
                    headerFilter.addFilter(new Filter(
                            e.getAttribute(FILTER_ID),
                            e.getAttribute(LABEL)));
                }
                System.out.println("Node Name =" + currentNode.getNodeName() + " [CLOSE]");

            }
        }
        return headerFilter;
    }

    private DataTableView parseDataTable(Document doc, String target) {
        Element list = Element.class.cast(doc.getElementsByTagName(LIST).item(0));
        DataTableView dataTableView = new DataTableView(list.getAttribute(ID), target)
                .setListType(list.getAttribute(TYPE))
                .setPageSize(list.getAttribute(PAGE_SIZE))
                .setTitle(list.getAttribute(TITLE));

        NodeList columns = doc.getElementsByTagName(COLUMNS);
        NodeList nodeList = columns.item(0).getChildNodes();
        OrderGenerator orderGenerator = registry.getGenerator(target);
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node currentNode = nodeList.item(count);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node name and value
                System.out.println("\nNode Name =" + currentNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + currentNode.getTextContent());
                dataTableView.addColumn(
                        getBuilder(currentNode.getNodeName())
                                .withGenerator(orderGenerator)
                                .buildFromNode(currentNode, target));

                System.out.println("Node Name =" + currentNode.getNodeName() + " [CLOSE]");

            }
        }
        return dataTableView;
    }
}
