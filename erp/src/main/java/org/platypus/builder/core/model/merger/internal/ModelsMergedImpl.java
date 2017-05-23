package org.platypus.builder.core.model.merger.internal;

import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.core.model.merger.ModelsMerged;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class ModelsMergedImpl implements ModelsMerged{

    private final Map<String, ModelMerged> models;


    public ModelsMergedImpl(Map<String, ModelMerged> models) {
        this.models = models;
    }

    @Override
    public ModelMerged getModel(String name) {
        return models.get(name);
    }

    @Override
    public Stream<ModelMerged> getModels() {
        return models.values().stream();
    }

    @Override
    public Stream<String> getModelNames() {
        return models.keySet().stream();
    }
}
