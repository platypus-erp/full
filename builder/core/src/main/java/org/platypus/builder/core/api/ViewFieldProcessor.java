package org.platypus.builder.core.api;

import org.platypus.api.annotations.PlatypusVersion;
import org.platypus.builder.core.model.merger.ModelMerged;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public interface ViewFieldProcessor {

    PlatypusVersion supportedVersion();

    int priority();

    void init(PlatypusBuilderMutableConf conf);

    boolean process(ModelMerged modelMerged, PlatypusBuilderImMutableConf conf, ProcessState state);
}
