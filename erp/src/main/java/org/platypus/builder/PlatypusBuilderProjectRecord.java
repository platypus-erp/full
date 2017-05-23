package org.platypus.builder;


import com.squareup.javapoet.JavaFile;
import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.ModuleLoader;
import org.platypus.builder.core.ModuleLoaderImpl;
import org.platypus.builder.core.api.ModelProcessor;
import org.platypus.builder.core.api.PlatypusPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public final class PlatypusBuilderProjectRecord {

    private final ModuleLoader moduleLoader;
    private final Map<String, PlatypusPlugin> pluginsDiscovered = new HashMap<>();
    private final List<ModelProcessor> modelProcessors = new ArrayList<>();
    private final MainArgs mainArgs;

    public static void main(String... args) {
        System.out.println(Arrays.toString(args));
        new PlatypusBuilderProjectRecord(new MainArgs(args));
    }

    public static PlatypusBuilderProjectRecord of(MainArgs mainArgs) {
        return new PlatypusBuilderProjectRecord(mainArgs);
    }

    private PlatypusBuilderProjectRecord(MainArgs mainArgs) {
        this.mainArgs = mainArgs;
        moduleLoader = new ModuleLoaderImpl(mainArgs);
//        Set<JavaFile.Builder> recordToCreate = moduleLoader.getRecordRegistry()
//                .generateCurrentModuleRecord(mainArgs.getDefaultPkg());
//
//        for (JavaFile.Builder files : recordToCreate) {
//            System.out.println(files.build().packageName);
//            try {
//                files.build().writeTo(mainArgs.getProjectDirGenerated().toFile());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
