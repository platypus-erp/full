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
    private final Path projectDir;
    private final Path projectDirGenerated;
    private final String moduleVersion;
//    private final String[] depends;
    private final String modulename;
//    private final String moduleQuickDesc;
    private final String defaultPkg;
//    private final String shortDesc;
//    private final String longDesc;
    private final Map<String, PluginConf> conf;

    public MainArgs(String ... args) {
        Map<String, String> argsMap = Arrays.stream(args)
                .map(s -> s.split("="))
                .collect(Collectors.toMap(t -> t[0], t -> t[1]));

        projectDir = Paths.get(argsMap.get("--directory"));
        projectDirGenerated = Paths.get(argsMap.get("--directory"), "src", "platypusgenerated", "java");
        modulename = argsMap.get("--modulename");
        defaultPkg = argsMap.get("--defaultpkg");
        moduleVersion = argsMap.get("--moduleVersion");

        conf = Stream.of(argsMap.getOrDefault("--plugins", ""))
                .map(s -> s.substring(1, s.length()-1))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(PluginConf::new)
                .collect(Collectors.toMap(PluginConf::getName, c -> c));
    }

    public Path getProjectDir() {
        return projectDir;
    }

    public Path getProjectDirGenerated() {
        return projectDirGenerated;
    }

    public String getModuleVersion() {
        return moduleVersion;
    }

    public String getModulename() {
        return modulename;
    }

    public String getDefaultPkg() {
        return defaultPkg;
    }

    public Map<String, PluginConf> getConf() {
        return conf;
    }
}
