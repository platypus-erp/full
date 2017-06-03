package org.platypus.builder.core.service.manager;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.platypus.builder.core.service.manager.astvisitor.AstService;
import org.platypus.builder.core.service.manager.astvisitor.ServiceVisitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class ModelsFinder {
    public static Set<ServiceVisitor> run(Path serviceDir) {
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.java");
        return Stream.of(serviceDir)
                .flatMap(ModelsFinder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(ModelsFinder::parseJava)
                .map(ServiceVisitor::getInfo)
                .filter(ServiceVisitor::isValidModel)
                .collect(Collectors.toSet());
    }

    private static Stream<Path> walkPath(Path p) {
        try {
            return Files.walk(p);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static CompilationUnit parseJava(Path path) {
        try {
            return JavaParser.parse(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
