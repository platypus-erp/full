package org.platypus.builder.core;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public class MainArgs {
    public final Path projectDir;
    public final Path mainDir;
    public final Path modelsDir;
    public final String projectDirStr;
    public final Path projectDirGenerated;
    public final String moduleVersion;
    public final String[] srcDirs;
    public final String[] depends;
    public final String modulename;
    public final String quickDesc;
    //    private  String moduleQuickDesc;
    public final String defaultPkg;
    //    private  String shortDesc;
//    private  String longDesc;
    public final Map<String, PluginConf> conf;

    public MainArgs(String... args) {
        System.out.println(Arrays.toString(args));
        Map<String, String> argsMap = Arrays.stream(args)
                .map(s -> s.split("="))
                .collect(Collectors.toMap(t -> t[0], t -> t[1]));
        projectDir = Paths.get(argsMap.get("--directory"));
        projectDirStr = argsMap.get("--directory");
        modulename = argsMap.get("--modulename");
        mainDir = Paths.get(argsMap.get("--mainDir"));
        modelsDir = Paths.get(argsMap.get("--modelsDir"));
        projectDirGenerated = Paths.get(argsMap.get("--generatedDir"));
        srcDirs = toArray(argsMap.get("--srcDirs"));

        quickDesc = argsMap.get("--moduleQuickDesc");
        depends = toArray(argsMap.get("--depends"));
        defaultPkg = argsMap.get("--defaultpkg");
        moduleVersion = argsMap.get("--moduleVersion");

        conf = Stream.of(argsMap.getOrDefault("--plugins", ""))
                .filter(String::isEmpty)
                .map(s -> s.substring(1, s.length() - 1))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(PluginConf::new)
                .collect(Collectors.toMap(PluginConf::getName, c -> c));
    }

    public static Path toPathToGenerate(String projectDir) {
        return Paths.get(projectDir, "src", "generated", "java");
    }

    public static Path toPathToMainJava(String projectDir) {
        return Paths.get(projectDir, "src", "main", "java");
    }
    public static Path toPathToMainJava(String projectDir, String modulename) {
        return Paths.get(projectDir, "src", "main", "java", modulename);
    }
    public static Path toPathToMainRessources(String projectDir) {
        return Paths.get(projectDir, "src", "main", "resources");
    }
    public static Path toPathToMainRessources(String projectDir, String modulename) {
        return Paths.get(projectDir, "src", "main", "resources", modulename);
    }
    public static Path toPathToMainServices(String projectDir) {
        return Paths.get(projectDir, "src", "main", "resources", "META-INF", "services");
    }

    public static String[] toArray(String array) {
        String formalStr = array.replace("[", "")
                .replace("]", "");
        if (formalStr.isEmpty()){
            return new String[0];
        }
        return formalStr.split(",");
    }
}
