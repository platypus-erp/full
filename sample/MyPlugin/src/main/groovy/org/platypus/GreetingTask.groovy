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
        println greeting
    }
}
