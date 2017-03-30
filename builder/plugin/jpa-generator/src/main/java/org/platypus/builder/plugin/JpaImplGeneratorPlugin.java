package org.platypus.builder.plugin;


import org.platypus.builder.core.plugin.PlatypusBuilderImMutableConf;
import org.platypus.builder.core.plugin.PlatypusBuilderMutableConf;
import org.platypus.builder.core.plugin.PlatypusPlugin;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class JpaImplGeneratorPlugin implements PlatypusPlugin {

    @Override
    public String getName() {
        return "generator-hibernate";
    }

    @Override
    public void init(PlatypusBuilderMutableConf conf) {

    }

    @Override
    public void execute(PlatypusBuilderImMutableConf conf) {

    }

    @Override
    public void after(PlatypusBuilderImMutableConf conf) {

    }

    @Override
    public void detroy(PlatypusBuilderImMutableConf conf) {

    }
}
