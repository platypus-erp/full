package org.platypus.builder.core.plugin;

import com.squareup.javapoet.TypeSpec;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 03/04/17.
 */
public interface ModelProcessorResult {

    boolean addTypeSpecBuilder(String packageName, String className, TypeSpec.Builder builder);

    boolean addRessource(String packageName, String fileName, Map<String, String> keyValue);

    boolean addOutPutRessource(String packageName, String fileName, OutputStream content);

    boolean addInputStreamRessource(String packageName, String fileName, InputStream content);

    boolean addStringRessource(String packageName, String fileName, String content);


}
