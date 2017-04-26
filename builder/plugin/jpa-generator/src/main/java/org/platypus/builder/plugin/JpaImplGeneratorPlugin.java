package org.platypus.builder.plugin;


import org.platypus.api.annotations.PlatypusVersion;
import org.platypus.builder.core.api.ModelProcessor;
import org.platypus.builder.core.api.ModelProcessorResult;
import org.platypus.builder.core.api.PlatypusBuilderImMutableConf;
import org.platypus.builder.core.api.PlatypusBuilderMutableConf;
import org.platypus.builder.core.api.ProcessState;
import org.platypus.builder.core.model.merger.ModelMerged;
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
            jpaModelGenerator.getJpaImplBuiler().values()
                    .forEach(s -> result.addTypeSpecBuilder(conf.getDefaultPackage()+".models.generated.jpa", s));

        }else {
            System.out.println("process "+modelMerged.getName());
            jpaModelGenerator.generate(modelMerged, conf::getRecord, conf::getRecordCollection);
        }
        return false;
    }

    @Override
    public ModelProcessorResult getResultProcessing(PlatypusBuilderImMutableConf conf) {
        return result;
    }
}
