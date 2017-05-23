package org.platypus.builder.core.api;

import org.platypus.api.Namable;
import org.platypus.builder.core.PluginConf;

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

    default void after(PlatypusBuilderImMutableConf conf){}

    default void detroy(PlatypusBuilderImMutableConf conf){}

    PluginConf getDefaultConf();

    void applyConf(PluginConf conf);
}
