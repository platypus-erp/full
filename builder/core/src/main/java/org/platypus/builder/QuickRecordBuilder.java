package org.platypus.builder;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.records.manager.QuickRecordGenerator;
import org.platypus.builder.core.records.manager.RecordFinder;
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
 * on 24/04/17.
 */
public class QuickRecordBuilder {
    public static void main(String[] args) throws Exception {
        args = new String[]{"[/home/chmuchme/WorkSpace/PLATYPUS/full/module/base/src/main/java]",
                "org.platypus.erp.module",
                "base"
                ,"/home/chmuchme/WorkSpace/PLATYPUS/full/module/base"};
        System.out.println(Arrays.toString(args));
        String[] srcDirs = args[0].replace("[", "").replace("]", "").split(",");
        run(srcDirs, args[1], args[2], args[3]);
    }

    public static void run(String[] srcDirs, String group, String name, String projectDir) throws Exception {
        new QuickRecordGenerator(MainArgs.toPathToGenerate(projectDir), group, name, RecordFinder.run(srcDirs))
                .generateRecord();
    }
}
