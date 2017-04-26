package org.platypus.builder;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.platypus.builder.core.records.quick.Visitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class QuickRecordBuilder {
    public static void run(String projectDir, String group, String name) throws Exception {
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.java");
        Visitor v = new Visitor();
        Stream.of(projectDir.replace("[", "").replace("]", "").split(","))
                .map(Paths::get)
                .flatMap(QuickRecordBuilder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(QuickRecordBuilder::parseJava)
                .map(Visitor::getInfo)
                .forEach(Visitor::toString);
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
