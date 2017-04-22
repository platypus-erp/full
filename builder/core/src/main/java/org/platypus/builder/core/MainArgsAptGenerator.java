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
public class MainArgsAptGenerator {
    private String projectDir;
    private String projectDirToGenerate;
    private String modulename;
    private String defaultPkg;
    private String moduleVersion;

    //    private  String shortDesc;
    //    private  String[] depends;
    //    private  String longDesc;
    //    private  String moduleQuickDesc;


    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    public String getProjectDirToGenerate() {
        return projectDirToGenerate;
    }

    public void setProjectDirToGenerate(String projectDirToGenerate) {
        this.projectDirToGenerate = projectDirToGenerate;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getDefaultPkg() {
        return defaultPkg;
    }

    public void setDefaultPkg(String defaultPkg) {
        this.defaultPkg = defaultPkg;
    }

    public String getModuleVersion() {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }
}
