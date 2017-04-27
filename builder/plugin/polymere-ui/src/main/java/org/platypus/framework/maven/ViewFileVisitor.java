package org.platypus.framework.maven;

import org.platypus.framework.maven.parser.DomParserError;
import org.platypus.framework.maven.shema.SchemaValidator;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ViewFileVisitor extends SimpleFileVisitor<Path> {
    private SchemaValidator shemaValidator;
    private List<Path> views = new ArrayList<>();

    public ViewFileVisitor() {
        shemaValidator = new SchemaValidator();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException
    {
        super.visitFile(file, attrs);
        if (!file.getFileName().toString().endsWith(".xml")){
            return FileVisitResult.CONTINUE;
        }
        DomParserError err = shemaValidator.validateFile(file);
        if (err.isWithOutError()){
            views.add(file);
        } else {
            System.out.println("ERROR");
            err.getSaxErrorMessage().stream().forEach(System.out::println);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getViews() {
        return views;
    }
}
