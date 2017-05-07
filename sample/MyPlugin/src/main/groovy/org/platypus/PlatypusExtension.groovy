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

    File shortDesc
    File longDesc

    PlatypusExtension(Project project) {
        projectDir = project.projectDir
        modulename = project.name
        moduleVersion = project.version
        baseGeneratedPackage = project.group.toString() + "." + project.name
        srcDirs = [project.file('src/main/java/'), project.file('src/main/resources')]
        shortDesc = project.file('src/main/resources/' + baseGeneratedPackage + '/short-desc.adoc')
        longDesc = project.file('src/main/resources/' + baseGeneratedPackage + '/long-desc.adoc')
    }

    String[] getArgs(){
        return ["--directory=${projectDir}",
                "--modulename=${modulename}",
                "--plugins=${conf}",
                "--srcDirs=${srcDirs}",
                "--defaultpkg=${baseGeneratedPackage}",
                "--moduleVersion=${moduleVersion}",
                "--depends=${depends}",
                "--moduleQuickDesc=${moduleQuickDesc}",
                "--shortDesc=${shortDesc}",
                "--longDesc=${longDesc}"]
    }
}
