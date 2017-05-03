package org.platypus.builder.core.views;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.platypus.builder.core.records.quick.Visitor;
import org.platypus.builder.core.views.list.SchemaValidator;
import org.platypus.builder.core.views.list.parser.DomParser;
import org.platypus.builder.core.views.list.parser.DomParserError;
import org.platypus.builder.core.views.list.structure.ListView;
import org.platypus.builder.core.views.list.structure.order.OrderGeneratorRegistry;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class ViewsFinder {
    public static void run(String projectDir, String group, String name) throws Exception {
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.xml");
        SchemaValidator schemaValidator = new SchemaValidator();
        OrderGeneratorRegistry orderGeneratorRegistry = new OrderGeneratorRegistry();
        DomParser parser = new DomParser(orderGeneratorRegistry);

        Set<ListView> listViews = Stream.of(projectDir.replace("[", "").replace("]", "").split(","))
                .map(Paths::get)
                .flatMap(ViewsFinder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
//                .filter(schemaValidator::validateFile)
                .map(parser::parseListView)
                .map(DomParserError::getListView)
                .collect(Collectors.toSet());

        for (ListView lv: listViews){
            lv.
        }
    }

    private static Stream<Path> walkPath(Path p){
        try {
            return Files.walk(p);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(args));
        run(args[0], args[1], args[2]);
    }

    private static CompilationUnit parseJava(Path path) {
        System.out.println(path.toString());
        try {
            return JavaParser.parse(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
