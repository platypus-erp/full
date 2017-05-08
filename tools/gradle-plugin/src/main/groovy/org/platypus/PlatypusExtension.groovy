package org.platypus

import org.gradle.api.Project

/**
 * @author chmuchme
 * @since 0.1
 * on 21/04/17.
 */
class PlatypusExtension {
    String moduleVersion
    String[] depends
    String projectDir
    String modulename
    String moduleQuickDesc
    String baseGeneratedPackage
    File[] srcDirs
    File mainDirs
    File modelsDir
    File generatedDir

    File shortDesc
    File longDesc

    PlatypusExtension(Project project) {
        projectDir = project.projectDir
        modulename = project.name
        moduleVersion = project.version
        baseGeneratedPackage = project.group.toString() + "." + project.name
        mainDirs = project.file('src/main/java/')
        modelsDir = project.file('src/models/java/')
        generatedDir = project.file('src/generated/java/')
        srcDirs = [mainDirs, modelsDir, generatedDir]
        shortDesc = project.file('src/main/resources/' + baseGeneratedPackage + '/short-desc.adoc')
        longDesc = project.file('src/main/resources/' + baseGeneratedPackage + '/long-desc.adoc')
    }

    String[] getArgs(){
        return ["--directory=${projectDir}",
                "--modulename=${modulename}",
                "--plugins=${conf}",
                "--mainDir=${mainDirs}",
                "--modelsDir=${modelsDir}",
                "--generatedDir=${generatedDir}",
                "--srcDirs=${srcDirs}",
                "--defaultpkg=${baseGeneratedPackage}",
                "--moduleVersion=${moduleVersion}",
                "--depends=${depends}",
                "--moduleQuickDesc=${moduleQuickDesc}",
                "--shortDesc=${shortDesc}",
                "--longDesc=${longDesc}"]
    }
}
