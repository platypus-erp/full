package org.platypus.builder.core.plugin;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 03/04/17.
 */
public interface ModelProcessorResult {

    boolean addJavaFileBuilder(JavaFile.Builder javaFileBuilder);

    void addTypeSpecBuilder(String packageName, Collection<TypeSpec.Builder> builders);

    Set<JavaFile.Builder> getAllFile();

    static ModelProcessorResult create(){
        return new ModelProcessorResultImpl();
    }

}
