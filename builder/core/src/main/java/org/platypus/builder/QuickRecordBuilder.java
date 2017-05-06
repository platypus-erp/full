package org.platypus.builder;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.platypus.builder.core.records.quick.QuickRecordGenerator;
import org.platypus.builder.core.records.quick.astvisitor.AstModel;
import org.platypus.builder.core.records.quick.astvisitor.Visitor;

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
 * on 24/04/17.
 */
public class QuickRecordBuilder {
    public static void run(String srcDirs, String group, String name, String projectDir) throws Exception {
        PathMatcher javaMatcher =
                FileSystems.getDefault().getPathMatcher("glob:**.java");
        String dir = srcDirs.replace("[", "").replace("]", "").split(",")[0];
        Set<AstModel> visitors = Stream.of(dir)
                .map(Paths::get)
                .flatMap(QuickRecordBuilder::walkPath)
                .filter(p -> !Files.isDirectory(p))
                .filter(javaMatcher::matches)
                .map(QuickRecordBuilder::parseJava)
                .map(Visitor::getInfo)
                .filter(Visitor::isValidModel)
                .collect(toSet());

        visitors.forEach(ast -> System.out.println(ast.toString()));
        QuickRecordGenerator g = new QuickRecordGenerator(projectDir, group, name);
        g.generateRecord(visitors);
    }

    private static Stream<Path> walkPath(Path p) {
        try {
            return Files.walk(p);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        args = new String[]{"[/home/chmuchme/WorkSpace/PLATYPUS/full/module/base/src/main/java]", "org.platypus.erp.module", "base"
                , "/home/chmuchme/WorkSpace/PLATYPUS/full/module/base"};
        System.out.println(Arrays.toString(args));
        run(args[0], args[1], args[2], args[3]);
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
