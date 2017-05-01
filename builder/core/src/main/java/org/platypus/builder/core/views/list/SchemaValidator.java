package org.platypus.builder.core.views.list;

import org.platypus.builder.core.views.list.parser.DomParserError;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
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
public class SchemaValidator {

    public boolean validateFile(Path path){
        DomParserError error = new DomParserError();
        try {
            Source xmlFile = new StreamSource(path.toFile());
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(SchemaValidator.class.getResource("platypus-list-views.xsd"));
            schema.newValidator().validate(xmlFile);
        } catch (SAXException e) {
            error.addSAXException(e);
        } catch (IOException e) {
            error.addIOException(e);
        }
        return error.isWithOutError();
    }
}
