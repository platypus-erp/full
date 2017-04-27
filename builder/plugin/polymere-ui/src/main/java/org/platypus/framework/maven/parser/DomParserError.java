package org.platypus.framework.maven.parser;

import org.platypus.framework.maven.conf.ViewTemplate;
import org.platypus.framework.maven.views.list.ListView;
import org.platypus.framework.maven.views.list.order.OrderGenerator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class DomParserError {
    private ListView listView;
    private OrderGenerator generator;
    private List<SAXException> saxExceptions = new ArrayList<>();
    private IOException ioException;
    private ParserConfigurationException parserConfigurationException;
    private ViewTemplate.ViewType type;

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public void addSAXException(SAXException e) {
        saxExceptions.add(e);
    }

    public void addParserConfigurationException(ParserConfigurationException e) {
        parserConfigurationException = e;
    }

    public void addIOException(IOException e) {
        ioException = e;
    }

    public boolean isWithOutError() {
        return saxExceptions.isEmpty() && ioException == null && parserConfigurationException == null;
    }

    public ViewTemplate.ViewType getType() {
        return ViewTemplate.ViewType.LIST;
    }

    public List<String> getSaxErrorMessage(){
        return saxExceptions.stream().map(e -> e.getMessage()).collect(toList());
    }

    public OrderGenerator getGenerator() {
        return generator;
    }

    public DomParserError setGenerator(OrderGenerator generator) {
        this.generator = generator;
        return this;
    }
}
