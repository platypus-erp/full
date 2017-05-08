package org.platypus

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.plugins.ide.idea.IdeaPlugin

/**
 * @author chmuchme
 * @since 0.1
 * on 21/04/17.
 * task platypus_records(type: JavaExec) {
 classpath = sourceSets.models.runtimeClasspath
 main = 'org.platypus.builder.QuickRecordBuilder'
 arguments to pass to the application
 args(project.platypus.getArgs())
 }task platypus_module_info(type: JavaExec) {
 dependsOn platypus_records
 classpath = sourceSets.models.runtimeClasspath
 main = 'org.platypus.builder.ModuleInfoBuilder'
 args(project.platypus.getArgs())
 }task platypus_views(type: JavaExec) {
 classpath = sourceSets.main.runtimeClasspath
 main = 'org.platypus.builder.core.views.ViewsFinder'
 // arguments to pass to the application
 args = ["${sourceSets.main.resources.srcDirs}", "${project.group}", "${project.name}", "${project.projectDir}"]
 }task platypus_build(type: JavaExec) {
 classpath = sourceSets.main.runtimeClasspath
 main = 'org.platypus.builder.PlatypusBuilder'
 args(project.platypus.getArgs())
 }
 */
class PlatypusGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("platypus", PlatypusExtension, project)

        project.platypus.extensions.conf = project.container(PlatypusPluginExtensionContainer)
        project.getPluginManager().apply(JavaPlugin.class)
        project.getPluginManager().apply(IdeaPlugin.class)
        project.sourceCompatibility = 1.8
        JavaPluginConvention javaConvention = project.getConvention().getPlugin(JavaPluginConvention.class)
        SourceSetContainer sourceSets = configureSourceSet(project, javaConvention.sourceSets)



        project.afterEvaluate {
            JavaExec recordTask = project.tasks.create("platypus_records", JavaExec)
            recordTask.classpath = sourceSets.getByName("empty").runtimeClasspath
            recordTask.main = 'org.platypus.builder.QuickRecordBuilder'
            recordTask.args((Object[]) project.platypus.getArgs())
            project.tasks.add(recordTask)

            JavaExec moduleInfoTask = project.tasks.create("platypus_module_info", JavaExec)
            moduleInfoTask.classpath = sourceSets.getByName("empty").runtimeClasspath
            moduleInfoTask.main = 'org.platypus.builder.ModuleInfoBuilder'
            moduleInfoTask.args((Object[]) project.platypus.getArgs())
            project.tasks.add(moduleInfoTask)

//        JavaExec viewsTask = project.tasks.create("platypus_views", JavaExec)
//        recordTask.classpath = sourceSets.models.runtimeClasspath
//        recordTask.main = 'org.platypus.builder.ViewsFinder'
//        recordTask.args(project.platypus.getArgs())

            JavaExec platypusBuildTask = project.tasks.create("platypus_build", JavaExec)
            platypusBuildTask.classpath = sourceSets.getByName("main").runtimeClasspath
            platypusBuildTask.main = 'org.platypus.builder.PlatypusBuilder'
            platypusBuildTask.args((Object[]) project.platypus.getArgs())
            project.tasks.add(platypusBuildTask)
        }
    }

    private SourceSetContainer configureSourceSet(Project project, SourceSetContainer sourceSets) {
        SourceSet modelsSourceset = sourceSets.create("models")
        modelsSourceset.java.srcDir('src/models/java')

        SourceSet generatedSourceset = sourceSets.create("generated")
        generatedSourceset.java.srcDir('src/generated/java')
        generatedSourceset.resources.srcDir('src/generated/resources')

        SourceSet emptySourceset = sourceSets.create("empty")
        SourceSet platypusSourceset = sourceSets.create("platypus")


        sourceSets.add(modelsSourceset)
        sourceSets.add(generatedSourceset)
        sourceSets.add(emptySourceset)
        sourceSets.add(platypusSourceset)

        sourceSets.getByName("main").compileClasspath += generatedSourceset.output
        sourceSets.getByName("main").runtimeClasspath += generatedSourceset.output
        sourceSets.getByName("main").compileClasspath += modelsSourceset.output
        sourceSets.getByName("main").runtimeClasspath += modelsSourceset.output
        return sourceSets
    }
}
