package org.platypus.builder.core.service;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import org.platypus.builder.core.records.manager.astvisitor.Visitor;
import org.platypus.builder.core.service.manager.visitor.ServiceCreator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class ServiceFinder {
    public static Map<ClassName, List<TypeSpec>> run(Path modelDir) {
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.java");
        return Stream.of(modelDir)
                .flatMap(ServiceFinder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(ServiceFinder::parseJava)
                .flatMap(cu -> ServiceCreator.getServices(cu).entrySet().stream())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        ServiceFinder::mergeList
                        ));
    }

    private static <T> List<T> mergeList(List<T> l1, List<T> l2) {
        List<T> l = new ArrayList<>(l1.size() + l2.size());
        l.addAll(l1);
        l.addAll(l2);
        return l;
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
