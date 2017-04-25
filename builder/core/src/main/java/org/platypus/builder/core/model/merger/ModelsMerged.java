package org.platypus.builder.core.model.merger;

import org.platypus.builder.core.model.merger.internal.ModelMerged;

import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public interface ModelsMerged {


    ModelMerged getModel(String name);
    Stream<ModelMerged> getModels();
    Stream<String> getModelNames();
}
