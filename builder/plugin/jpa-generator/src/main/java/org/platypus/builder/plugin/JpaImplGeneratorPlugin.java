package org.platypus.builder.plugin;


import com.squareup.javapoet.JavaFile;
import org.platypus.api.annotations.PlatypusVersion;
import org.platypus.builder.core.plugin.ModelProcessor;
import org.platypus.builder.core.plugin.ModelProcessorResult;
import org.platypus.builder.core.plugin.PlatypusBuilderImMutableConf;
import org.platypus.builder.core.plugin.PlatypusBuilderMutableConf;
import org.platypus.builder.core.plugin.ProcessState;
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
    ModelProcessorResult result;
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
        System.out.println("init");
    }

    @Override
    public boolean process(ModelMerged modelMerged, PlatypusBuilderImMutableConf conf, ProcessState state) {
        if (ProcessState.FINISH == state){
            result = ModelProcessorResult.create();
            result.addTypeSpecBuilder(conf.getDefaultPackage()+".model.jpa",
                    jpaModelGenerator.getJpaImplBuiler().values());
        }else {
            System.out.println("process "+modelMerged.getName());
            jpaModelGenerator.generate(modelMerged);
        }
        return false;
    }

    @Override
    public ModelProcessorResult getResultProcessing(PlatypusBuilderImMutableConf conf) {
        return result;
    }
}
