package org.platypus.builder.core.plugin;

import org.platypus.api.Namable;
import org.platypus.api.module.PlatypusVersion;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;

/**
 * @author chmuchme
 * @since 0.1
 * on 03/04/17.
 */
public interface ModelProcessor extends Namable{

    PlatypusVersion supportedVersion();

    int priority();

    void init(PlatypusBuilderMutableConf conf);

    boolean process(ModelMerged modelMerged);

    ModelProcessorResult afterProcess();

    default ModelProcessorResult newResult(){
        return null;
    }
}
