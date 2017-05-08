package org.platypus.builder.core.views;

import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.views.list.SchemaValidator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */

public class ViewsFinder {

    public static void main(String[] args) {
        System.out.println(find("/home/chmuchme/WorkSpace/PLATYPUS/full/module/base", "base"));
    }

    public static Set<Path> find(String projectDirStr, String moduleName) {
        PathMatcher javaMatcher = FileSystems.getDefault().getPathMatcher("glob:**.xml");

        SchemaValidator schemaValidator = new SchemaValidator();

        return Stream.of(MainArgs.toPathToMainRessources(projectDirStr, moduleName)
                .resolve("views"))
                .flatMap(ViewsFinder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(p -> MainArgs.toPathToMainRessources(projectDirStr, moduleName).relativize(p))
                .collect(Collectors.toSet());
    }

    private static Stream<Path> walkPath(Path p) {
        try {
            return Files.walk(p);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
