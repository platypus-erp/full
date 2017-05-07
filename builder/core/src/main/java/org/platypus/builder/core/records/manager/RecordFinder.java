package org.platypus.builder.core.records.manager;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import org.platypus.builder.core.records.manager.astvisitor.Visitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class RecordFinder {
    public static Set<AstModel> run(String[] srcDirs) {
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.java");
        return Stream.of(srcDirs)
                .map(String::trim)
                .map(Paths::get)
                .flatMap(RecordFinder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(RecordFinder::parseJava)
                .map(Visitor::getInfo)
                .filter(Visitor::isValidModel)
                .collect(toSet());
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
