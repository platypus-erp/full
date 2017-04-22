package org.platypus

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.plugins.ide.idea.IdeaPlugin

/**
 * @author chmuchme
 * @since 0.1
 * on 21/04/17.
 */
class Greeting implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("platypus", PlatypusExtension, project)
        project.configurations.create("models")
        project.configurations.create("apt_resources")

        project.platypus.extensions.conf = project.container(PlatypusPluginExtensionContainer)
        project.getPluginManager().apply(ApplicationPlugin.class)
        project.getPluginManager().apply(JavaPlugin.class)
        project.getPluginManager().apply(IdeaPlugin.class)
        project.sourceCompatibility = 1.8
        project.mainClassName = "org.platypus.builder.core.PlatypusBuilder"
        project.task('hello', type: GreetingTask)

//        project.run {
//            doFirst {
//                args project.platypus.getArgs()
//            }
//        }
    }
}
