package org.platypus.builder.plugin;


import org.platypus.api.module.PlatypusVersion;
import org.platypus.builder.core.plugin.ModelProcessor;
import org.platypus.builder.core.plugin.ModelProcessorResult;
import org.platypus.builder.core.plugin.PlatypusBuilderImMutableConf;
import org.platypus.builder.core.plugin.PlatypusBuilderMutableConf;
import org.platypus.builder.core.plugin.PlatypusPlugin;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.plugin.internal.JpaModelGenerator;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class JpaImplGeneratorPlugin implements ModelProcessor {

    @Override
    public String getName() {
        return "generator-hibernate";
    }

    JpaModelGenerator jpaModelGenerator;

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public PlatypusVersion supportedVersion() {
        return null;
    }

    @Override
    public void init(PlatypusBuilderMutableConf conf) {
        jpaModelGenerator = new JpaModelGenerator();
    }

    @Override
    public boolean process(ModelMerged modelMerged) {
        jpaModelGenerator.generate(modelMerged);
        return false;
    }

    @Override
    public ModelProcessorResult afterProcess() {
        ModelProcessorResult result = newResult();
        jpaModelGenerator.getJpaImplBuiler().values().forEach(t -> result.addTypeSpecBuilder("","", t));
        return result;
    }
}
