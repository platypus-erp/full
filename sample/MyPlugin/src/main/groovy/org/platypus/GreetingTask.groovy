package org.platypus

import com.squareup.javapoet.*
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path
import java.nio.file.Paths

/**
 * @author chmuchme
 * @since 0.1
 * on 21/04/17.
 */
class GreetingTask extends DefaultTask {
    String greeting = 'hello from GreetingTask'
    @TaskAction
    def greet() {
        TypeSpec.Builder mainBuilder = TypeSpec.classBuilder("MainBuilder");
        MethodSpec.Builder main = MethodSpec.methodBuilder("main")
                .addParameter(ParameterSpec.builder(ArrayTypeName.of(ClassName.get(String)), 'args').build())
        ClassName mainArgsClass = ClassName.get('org.platypus.builder.core', 'MainArgsAptGenerator')
        String mainArgsVar = 'mainArgs'
        CodeBlock declareMainArgs = CodeBlock.of("$T $N = new $T();", mainArgsClass, mainArgsVar, mainArgsClass)
        CodeBlock setProjectDir = CodeBlock.of('$N.setProjectDir($S)',
                mainArgsVar,
                project.platypus.projectDir)
        CodeBlock projectDirGenerated = CodeBlock.of('$N.setProjectDirToGenerate($S)',
                mainArgsVar,
                project.platypus.baseGeneratedPackage)
        CodeBlock modulename = CodeBlock.of('$N.setModulename($S)',
                mainArgsVar,
                project.platypus.modulename)
        CodeBlock defaultpkg = CodeBlock.of('$N.setDefaultPkg($S)',
                mainArgsVar,
                project.platypus.baseGeneratedPackage)
        CodeBlock moduleVersion = CodeBlock.of('$N.setModuleVersion($S)',
                mainArgsVar,
                project.platypus.moduleVersion)
        main.addCode(declareMainArgs)
        main.addCode(setProjectDir)
        main.addCode(projectDirGenerated)
        main.addCode(modulename)
        main.addCode(defaultpkg)
        main.addCode(moduleVersion)
        mainBuilder.addMethod(main.build())
        File javaFile = Paths.get(project.platypus.projectDir.toString(), "src", "apt_generated", "java")
                .toFile().mkdirs()
        JavaFile.builder(project.group.toString() + "." +project.name, mainBuilder.build())
        .build().writeTo(javaFile)
        println greeting
    }
}
