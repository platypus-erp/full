package org.platypus.builder.core.plugin;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 16/04/17.
 */
public class ModelProcessorResultImpl implements ModelProcessorResult {
    Set<JavaFile.Builder> javaFiles = new HashSet<>();

    @Override
    public boolean addJavaFileBuilder(JavaFile.Builder javaFileBuilder) {
        return javaFiles.add(javaFileBuilder);
    }

    @Override
    public void addTypeSpecBuilder(final String packageName, Collection<TypeSpec.Builder> builders) {
        builders.forEach(b -> javaFiles.add(JavaFile.builder(packageName, b.build())));
    }

    @Override
    public Set<JavaFile.Builder> getAllFile() {
        return Collections.unmodifiableSet(javaFiles);
    }
}
