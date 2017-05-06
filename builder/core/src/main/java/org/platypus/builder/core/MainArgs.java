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
    private Path projectDir;
    private Path projectDirGenerated;
    private String moduleVersion;
    private String[] srcDirs;
    //    private  String[] depends;
    private String modulename;
    //    private  String moduleQuickDesc;
    private String defaultPkg;
    //    private  String shortDesc;
//    private  String longDesc;
    private Map<String, PluginConf> conf;

    public MainArgs(String... args) {
        Map<String, String> argsMap = Arrays.stream(args)
                .map(s -> s.split("="))
                .collect(Collectors.toMap(t -> t[0], t -> t[1]));
        projectDir = Paths.get(argsMap.get("--directory"));
        projectDirGenerated = toPathToGenerate(argsMap.get("--directory"));
        modulename = argsMap.get("--modulename");
        defaultPkg = argsMap.get("--defaultpkg");
        srcDirs = argsMap.get("--srcDirs")
                .replace("[", "")
                .replace("]", "")
                .split(",");
        moduleVersion = argsMap.get("--moduleVersion");

        conf = Stream.of(argsMap.getOrDefault("--plugins", ""))
                .filter(String::isEmpty)
                .map(s -> s.substring(1, s.length() - 1))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(PluginConf::new)
                .collect(Collectors.toMap(PluginConf::getName, c -> c));
    }

    public static Path toPathToGenerate(String projectDir){
        return Paths.get(projectDir, "src", "generated", "java");
    }

    public Path getProjectDir() {
        return projectDir;
    }

    public String[] getSrcDirs() {
        return srcDirs;
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

    public void setProjectDir(Path projectDir) {
        this.projectDir = projectDir;
    }

    public void setProjectDirGenerated(Path projectDirGenerated) {
        this.projectDirGenerated = projectDirGenerated;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public void setDefaultPkg(String defaultPkg) {
        this.defaultPkg = defaultPkg;
    }

    public void setConf(Map<String, PluginConf> conf) {
        this.conf = conf;
    }
}
