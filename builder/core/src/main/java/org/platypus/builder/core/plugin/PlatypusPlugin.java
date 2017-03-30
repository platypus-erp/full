package org.platypus.builder.core.plugin;

import org.platypus.api.Namable;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface PlatypusPlugin extends Namable {

    void init(PlatypusBuilderMutableConf conf);

    void execute(PlatypusBuilderImMutableConf conf);

    void after(PlatypusBuilderImMutableConf conf);

    void detroy(PlatypusBuilderImMutableConf conf);
}
