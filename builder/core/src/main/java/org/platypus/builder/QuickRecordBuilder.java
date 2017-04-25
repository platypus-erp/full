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

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class QuickRecordBuilder {

    public static void main(String[] args) throws Exception {
        String projectDir = "/home/chmuchme/WorkSpace/PLATYPUS/full/sample/sample_depends";
        String group = "org.platypus.sample";
        String name = "sample_depends";
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.java");
        Visitor v = new Visitor();
        Files.walk(Paths.get(projectDir, "src", "models"))
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(QuickRecordBuilder::parseJava)
                .map(Visitor::getInfo)
                .forEach(Visitor::toString);
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
